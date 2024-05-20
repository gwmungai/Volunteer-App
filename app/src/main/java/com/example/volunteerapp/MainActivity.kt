package com.example.volunteerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.navigation.AppNavHost
import com.example.volunteerapp.ui.theme.VolunteerAppTheme
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VolunteerAppTheme {
                val context = this
                AppNavHost(
                    context = context,
                    navController = rememberNavController(),
                    onSignUpSuccess = {
                    }
                )
                FirebaseApp.initializeApp(this)
            }
        }
    }
}
