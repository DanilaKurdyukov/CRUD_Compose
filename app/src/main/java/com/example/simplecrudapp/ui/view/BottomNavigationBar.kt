package com.example.simplecrudapp.ui.view

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.simplecrudapp.R
import com.example.simplecrudapp.data.navigation.NavBarItem
import com.example.simplecrudapp.data.navigation.Route
import com.example.simplecrudapp.ui.theme.darkBurgundy
import com.example.simplecrudapp.ui.theme.white

object NavBarItems {
    val items = listOf<NavBarItem>(
        NavBarItem(
            title = "Сотрудники",
            imageId = R.drawable.baseline_person_24,
            route = Route.Employee.route
        ),
        NavBarItem(
            title = "Должности",
            imageId = R.drawable.outline_attach_money_24,
            route = Route.Position.route
        ),
        NavBarItem(
            title = "Компании",
            imageId = R.drawable.outline_home_work_24,
            route = Route.Company.route
        )
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier.navigationBarsPadding()
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry.value?.destination?.route
        NavBarItems.items.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = darkBurgundy,
                    selectedIconColor = white
                ),
                selected = currentRoute == item.route,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.imageId),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title
                    )
                },
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}