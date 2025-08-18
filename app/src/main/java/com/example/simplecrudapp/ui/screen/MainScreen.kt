package com.example.simplecrudapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.simplecrudapp.data.Person
import com.example.simplecrudapp.ui.PersonCardItem

@Composable
fun MainScreen(modifier: Modifier) {
    PersonCardItem(
        Person(
            name = "KDD",
            age = 23,
            weight = 80
        )
    )
}