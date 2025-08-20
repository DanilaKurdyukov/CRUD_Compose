package com.example.simplecrudapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.simplecrudapp.R
import com.example.simplecrudapp.data.Company
import com.example.simplecrudapp.data.Employee
import com.example.simplecrudapp.data.Position
import com.example.simplecrudapp.ui.theme.SimpleCRUDAppTheme
import com.example.simplecrudapp.ui.theme.blackViolet
import com.example.simplecrudapp.ui.view.EmployeeCardItem
class MainActivity : ComponentActivity() {

    val employees = mutableStateListOf(
        Employee(
            id = 1,
            firstName = "Kurduykov",
            middleName = "Danila",
            lastName = "Denisovich",
            age = 23,
            position = Position(
                id = 1,
                name = "Engineneer",
                salary = 120000.0
            ),
            company = Company(
                id = 1,
                name = "TSPC"
            )
        ),
        Employee(
            id = 1,
            firstName = "Tkachenko",
            middleName = "Daniil",
            lastName = "Alekseevich",
            age = 23,
            position = Position(
                id = 1,
                name = "Manager",
                salary = 150000.0
            ),
            company = Company(
                id = 1,
                name = "X5 Group"
            )
        ),
        Employee(
            id = 1,
            firstName = "Sholokhov",
            middleName = "Maksim",
            lastName = "Dmitrievich",
            age = 22,
            position = Position(
                id = 1,
                name = "Manager",
                salary = 130000.0
            ),
            company = Company(
                id = 1,
                name = "X5 Group"
            )
        )
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
                    }
                ) { innerPadding ->
                    ConstraintLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        val (personList, txt1) = createRefs()
                        EmployeeList(
                            modifier = Modifier.constrainAs(personList) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun EmployeeList(modifier: Modifier){
        LazyColumn(
            modifier = modifier.padding(top = 10.dp)
        ) {
            items(items = employees) { employee ->
                EmployeeCardItem(employee)
            }
        }
    }

}

