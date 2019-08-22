package com.stevechulsdev.googlelogintestproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseUser
import com.stevechulsdev.scsns.ScSnsGoogle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var TAG: String = javaClass.simpleName
    override fun onStart() {
        super.onStart()

//        Log.e(TAG, "${ScSnsGoogle.isLogin()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ScSnsGoogle.initLogin(this, "")
//
//        bt_login.setOnClickListener {
//            ScSnsGoogle.login(this, 9090)
//        }
//
//        bt_logout.setOnClickListener {
//            ScSnsGoogle.logout(this, object : ScSnsGoogle.LogoutInterface {
//                override fun success() {
//                    Log.e(TAG, "logout success")
//                }
//
//                override fun fail(errorMsg: String) {
//                    Log.e(TAG, "logout fail : $errorMsg")
//                }
//            })
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        when(requestCode) {
//            9090 -> {
//                ScSnsGoogle.getUser(this@MainActivity, data!!, object : ScSnsGoogle.GetUserInterface {
//                    override fun success(user: FirebaseUser) {
//                        user.apply {
//                            Log.e(TAG, "name : $displayName")
//                            Log.e(TAG, "email : $email")
//                            Log.e(TAG, "photoUrl : $photoUrl")
//                            Log.e(TAG, "emailVerified : $isEmailVerified")
//                            Log.e(TAG, "uid : $uid")
//                        }
//                    }
//
//                    override fun fail(errorMsg: String) {
//                        Log.e(TAG, errorMsg)
//                    }
//                })
//            }
//        }
    }

    //    private lateinit var googleSignInClient: GoogleSignInClient
//    private lateinit var auth: FirebaseAuth

//    override fun onStart() {
//        super.onStart()
//
//        // 로그인 유무 확인, null 이면 로그인 X
//        // Check if user is signed in (non-null) and update UI accordingly.
//        auth.currentUser?.let {
//            Log.e(TAG, "로그인 O")
//        } ?: run {
//            Log.e(TAG, "로그인 X")
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Initialize Firebase Auth
//        auth = FirebaseAuth.getInstance()
//
//        // Configure ScSnsGoogle Sign In
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken("470632774829-3g70nqqa8qni80q2lhb60juuifiq022e.apps.googleusercontent.com")
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        bt_login.setOnClickListener {
//            val signInIntent = googleSignInClient.signInIntent
//            startActivityForResult(signInIntent, 9090)
//        }
//
//        bt_logout.setOnClickListener {
//            googleLogout()
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == 9090) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                // ScSnsGoogle Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)
//                firebaseAuthWithGoogle(account!!)
//            } catch (e: ApiException) {
//                // ScSnsGoogle Sign In failed, update UI appropriately
//                Log.w(TAG, "ScSnsGoogle sign in failed", e)
//                // ...
//            }
//        }
//    }
//
//    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
//        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id!!)
//
//        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "signInWithCredential:success")
//                    val user = auth.currentUser
////                    updateUI(user)
//
////                    val user = FirebaseAuth.getInstance().currentUser
//                    user?.let {
//                        // Name, email address, and profile photo Url
//                        val name = user.displayName
//                        val email = user.email
//                        val photoUrl = user.photoUrl
//
//                        // Check if user's email is verified
//                        val emailVerified = user.isEmailVerified
//
//                        // The user's ID, unique to the Firebase project. Do NOT use this value to
//                        // authenticate with your backend server, if you have one. Use
//                        // FirebaseUser.getToken() instead.
//                        val uid = user.uid
//
//                        Log.e(TAG, "name : $name")
//                        Log.e(TAG, "email : $email")
//                        Log.e(TAG, "photoUrl : $photoUrl")
//                        Log.e(TAG, "emailVerified : $emailVerified")
//                        Log.e(TAG, "uid : $uid")
//                    }
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w(TAG, "signInWithCredential:failure", task.exception)
////                    Snackbar.make(main_layout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
////                    updateUI(null)
//                }
//            }
//    }
//
//    private fun googleLogout() {
//        auth.signOut()
//        // ScSnsGoogle sign out
//        googleSignInClient.signOut().addOnCompleteListener(this) {
////            updateUI(null)
//            Log.e(TAG, "logout")
//        }
//    }
}
