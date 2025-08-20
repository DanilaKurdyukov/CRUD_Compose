package com.example.simplecrudapp.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.simplecrudapp.R
import com.example.simplecrudapp.data.navigation.NavBarItem
import com.example.simplecrudapp.data.navigation.Route

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

    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry.value?.destination?.route
        NavBarItems.items.forEach { item ->
            NavigationBarItem(
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