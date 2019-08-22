package com.stevechulsdev.scsns

import android.app.Activity
import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

object ScSnsGoogle {
    private val TAG: String = javaClass.simpleName

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    fun isLogin(): Boolean {
        auth.currentUser?.let {
            return true
        } ?: run {
            return false
        }
    }

    fun initLogin(activity: Activity, requestIdToken: String) {
        auth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(requestIdToken)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(activity, gso)
    }

    fun login(activity: Activity, requestCode: Int) {
        activity.startActivityForResult(googleSignInClient.signInIntent, requestCode)
    }

    fun getUser(activity: Activity, data: Intent, getUserInterface: GetUserInterface) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            task.getResult(ApiException::class.java)?.let {
                it.apply {

                    val credential = GoogleAuthProvider.getCredential(this.idToken, null)

                    auth.signInWithCredential(credential)
                        .addOnCompleteListener(activity) { task ->
                            if(task.isSuccessful) {
                                auth.currentUser?.let { firebaseUser ->
                                    getUserInterface.success(firebaseUser)
                                }
                            }
                            else {
                                task.exception?.let { exception ->
                                    exception.message?.let { errorMsg ->
                                        getUserInterface.fail(errorMsg)
                                    }?: run {
                                        getUserInterface.fail("getUser fail errorMessage null")
                                    }
                                } ?: run {
                                    getUserInterface.fail("getUser fail exception null")
                                }
                            }
                        }
                }
            } ?: run {
                getUserInterface.fail("getUser fail task.getResult(ApiException::class.java) null")
            }
        }
        catch (e: ApiException) {
            getUserInterface.fail("getUser fail : ${e.message}")
            Log.e(TAG, "ScSnsGoogle sign in failed : ${e.message}")
        }
    }

    fun logout(activity: Activity, logoutInterface: LogoutInterface) {
        auth?.let {
            it.signOut()

            googleSignInClient?.let { googleSignInClient ->
                googleSignInClient.signOut().addOnCompleteListener(activity) {
                    logoutInterface.success()
                }

                googleSignInClient.signOut().addOnFailureListener(activity) { exception ->
                    exception.message?.let { errorMsg ->
                        logoutInterface.fail(errorMsg)
                    } ?: run {
                        logoutInterface.fail("signout fail errorMessage null")
                    }
                }
            } ?: run {
                logoutInterface.fail("signout fail googleSignInClient null")
            }
        } ?: run {
            logoutInterface.fail("signout fail auth null")
        }
    }

    interface GetUserInterface {
        fun success(user: FirebaseUser)
        fun fail(errorMsg: String)
    }

    interface LogoutInterface {
        fun success()
        fun fail(errorMsg: String)
    }
}