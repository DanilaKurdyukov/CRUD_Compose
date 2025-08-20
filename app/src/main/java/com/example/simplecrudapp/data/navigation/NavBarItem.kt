package com.example.simplecrudapp.data.navigation

import androidx.annotation.DrawableRes

data class NavBarItem(
    val title: String,
    @DrawableRes val imageId: Int,
    val route: String
)
