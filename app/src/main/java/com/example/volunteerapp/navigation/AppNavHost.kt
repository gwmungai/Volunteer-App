package com.example.volunteerapp.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.dashboard.BottomNavigationBar
import com.example.volunteerapp.splash.SplashScreen
import com.example.volunteerapp.ui.theme.accounts.LoginScreen
import com.example.volunteerapp.ui.theme.accounts.SignUpScreen
import com.example.volunteerapp.ui.theme.home.HomeScreen
import com.example.volunteerapp.ui.theme.list.ListScreen
import com.example.volunteerapp.ui.theme.profile.AboutUsScreen
import com.example.volunteerapp.ui.theme.profile.ProfileScreen
import com.example.volunteerapp.ui.theme.profile.SettingsScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavHostController = rememberNavController(),
               context: Context,
               onSignUpSuccess: () ->Unit,
               startDestination: String= ROUTE_LOGIN
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            modifier = modifier.padding(innerPadding),
            startDestination = startDestination
        ) {
            composable(ROUTE_HOME){
                HomeScreen(navController)
            }
            composable(ROUTE_LIST) {
                ListScreen(navController)
            }
            composable(ROUTE_SIGNUP) {
                SignUpScreen(navController, onSignUpSuccess)
            }
            composable(ROUTE_LOGIN) {
                LoginScreen(navController,context)
            }
            composable(ROUTE_PROFILE) {
                ProfileScreen(navController)
            }
            composable(ROUTE_SETTINGS) {
                SettingsScreen(navController)
            }
            composable(ROUTE_ABOUTUS) {
                AboutUsScreen(navController)
            }
            composable(ROUTE_SPLASH) {
                SplashScreen(navController)
            }
        }
    }
}
//const val ROUTE_LIST ="list"



