package com.kotlintut.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlintut.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Mehedi H Tanvir",
                        modifier = Modifier.padding(innerPadding)
                    )
                    SimpleRow()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hi $name!",
        modifier = modifier
    )
}

@Composable
fun SimpleRow() {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("First Column-")
            Button( onClick = {/*TODO*/}) {
                Text("Click me!")
            }
        }
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("-Second Column")
            Button( onClick = {/*TODO*/}) {
                Text("No, Click me!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
//        Greeting("Tanvir")
        SimpleRow()
    }
}