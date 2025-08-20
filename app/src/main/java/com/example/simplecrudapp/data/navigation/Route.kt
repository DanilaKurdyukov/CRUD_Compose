package com.example.simplecrudapp.data.navigation

sealed class Route(val route: String) {
    object Employee: Route(route = "employee")
    object Position: Route(route = "position")
    object Company: Route(route = "company")
}