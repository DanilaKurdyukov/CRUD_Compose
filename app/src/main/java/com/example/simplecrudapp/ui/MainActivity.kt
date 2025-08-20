package com.example.simplecrudapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.simplecrudapp.R
import com.example.simplecrudapp.data.navigation.Route
import com.example.simplecrudapp.ui.screen.MainScreen
import com.example.simplecrudapp.ui.theme.SimpleCRUDAppTheme
import com.example.simplecrudapp.ui.theme.blackViolet
import com.example.simplecrudapp.ui.view.BottomNavigationBar

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            SimpleCRUDAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name)
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = blackViolet
                            )
                        )
                    },
                    bottomBar = {
                        BottomNavigationBar(navController)
                    },
                    floatingActionButton = {
                        val backStackEntry = navController.currentBackStackEntryAsState()
                        val currentRoute = backStackEntry.value?.destination?.route
                        if(currentRoute == Route.Employee.route) {
                            FloatingActionButton(
                                onClick = {

                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Добавить"
                                )
                            }
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End,
                ) { innerPadding ->
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        NavGraph(modifier = Modifier)
                    }
                }
            }
        }
    }

    @Composable
    fun NavGraph(modifier: Modifier) {
        Column(modifier = modifier) {
            NavHost(
                modifier = modifier.weight(weight = 1f),
                navController = navController,
                startDestination = Route.Employee.route
            ) {
                composable(route = Route.Employee.route) { MainScreen(modifier = modifier) }
                composable(route = Route.Position.route) { MainScreen(modifier = modifier) }
                composable(route = Route.Company.route) { MainScreen(modifier = modifier) }
            }
        }
    }

}

