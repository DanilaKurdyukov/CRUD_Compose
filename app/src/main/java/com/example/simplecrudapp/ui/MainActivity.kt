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
import com.example.simplecrudapp.ui.theme.SimpleCRUDAppTheme
import com.example.simplecrudapp.ui.theme.blackViolet

class MainActivity : ComponentActivity() {

    val persons = mutableStateListOf(
        Person(
            name = "Kurdyukov",
            age = 23,
            weight = 80
        ),
        Person(
            name = "Sholokhov",
            age = 23,
            weight = 80
        ),
        Person(
            name = "Andreev",
            age = 23,
            weight = 80
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
                        PersonList(
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
    fun PersonList(modifier: Modifier){
        LazyColumn(
            modifier = modifier.padding(top = 10.dp)
        ) {
            items(items = persons) { person ->
                PersonCardItem(person)
            }
        }
    }

}

