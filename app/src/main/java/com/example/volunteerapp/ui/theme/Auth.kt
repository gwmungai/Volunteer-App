package com.example.volunteerapp.ui.theme

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.volunteerapp.navigation.ROUTE_HOME
import com.example.volunteerapp.navigation.ROUTE_LOGIN
import com.example.volunteerapp.navigation.ROUTE_SIGNUP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavController, var context: Context){

    private var mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val progress: ProgressDialog = ProgressDialog(context).apply {
        setTitle("Loading")
        setMessage("Please Wait.....")
    }
    fun signup(email: String, pass: String, confpass: String) {
        progress.show()

        when {
            email.isBlank() || pass.isBlank() || confpass.isBlank() -> {
                progress.dismiss()
                showToast("Email and password cannot be blank")
            }
            pass != confpass -> {
                progress.dismiss()
                showToast("Passwords do not match")
            }
            else -> {
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userData = User(email, pass, mAuth.currentUser!!.uid) // Ensure User class exists
                        val regRef = FirebaseDatabase.getInstance().getReference("Users/${mAuth.currentUser!!.uid}")
                        regRef.setValue(userData).addOnCompleteListener { regTask ->
                            progress.dismiss()
                            if (regTask.isSuccessful) {
                                showToast("Registered Successfully")
                                navController.navigate(ROUTE_HOME)
                            } else {
                                showToast(regTask.exception?.message ?: "Registration failed")
                                navController.navigate(ROUTE_LOGIN)
                            }
                        }
                    } else {
                        progress.dismiss()
                        showToast(task.exception?.message ?: "Sign up failed")
                        navController.navigate(ROUTE_SIGNUP)
                    }
                }
            }
        }
    }

    fun login(email: String, pass: String) {
        progress.show()
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            progress.dismiss()
            if (task.isSuccessful) {
                showToast("Successfully Logged in")
                navController.navigate(ROUTE_HOME)
            } else {
                showToast(task.exception?.message ?: "Login failed")
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isLoggedIn(): Boolean {
        return mAuth.currentUser != null
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}

data class User(
    val email: String,
    val password: String,
    val uid: String
)

const val ROUTE_HOME = "home"
const val ROUTE_LOGIN = "login"
const val ROUTE_SIGNUP = "signup"
