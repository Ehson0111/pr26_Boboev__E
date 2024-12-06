package com.example.pr26_boboev__e

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr26_boboev__e.screen.addpaymentmethod

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.mainscrenn.route
    ) {
        composable(route = Screen.mainscrenn.route) {
            mainscreen(navController = navController)
        }
        composable(route = Screen.pay.route) {
            addpaymentmethod(navController = navController)
        }
    }
}
