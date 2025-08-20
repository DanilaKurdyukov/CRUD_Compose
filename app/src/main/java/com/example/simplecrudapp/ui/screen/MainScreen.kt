package com.example.simplecrudapp.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecrudapp.data.Company
import com.example.simplecrudapp.data.Employee
import com.example.simplecrudapp.data.Position
import com.example.simplecrudapp.ui.view.EmployeeCardItem

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

@Composable
fun MainScreen(modifier: Modifier) {
    EmployeeList(modifier = modifier, employees = employees)
}

@Composable
fun EmployeeList(modifier: Modifier, employees: List<Employee>){
    LazyColumn(
        modifier = modifier.padding(top = 10.dp)
    ) {
        items(items = employees) { employee ->
            EmployeeCardItem(employee)
        }
    }
}