package com.example.simplecrudapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecrudapp.data.Person

@Composable
fun PersonCardItem(person: Person) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.weight(weight = 1f)
            ) {
                Text(
                    text = "Фамилия:"
                )
                Text(
                    text = "Имя:"
                )
                Text(
                    text = "Отчество:"
                )
            }
            Column(
                Modifier.weight(2f)
            ) {
                Text(
                    text = person.name
                )
                Text(
                    text = person.age.toString()
                )
                Text(
                    text = person.weight.toString()
                )
            }
        }
    }
}