package com.mohammedfares.phones.ui

sealed class Screen(val route: String){
    object Home: Screen("home")
    object Details: Screen("details")
    object add: Screen("add")
}
