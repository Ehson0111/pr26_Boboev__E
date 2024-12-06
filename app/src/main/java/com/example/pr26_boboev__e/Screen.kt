package com.example.pr26_boboev__e


sealed class Screen(val route: String) {
    object mainscrenn : Screen("mainsvreen")
    object pay : Screen("pay")
}