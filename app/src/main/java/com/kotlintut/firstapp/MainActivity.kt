package com.kotlintut.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("JetPack Compose",
                style = MaterialTheme.typography.headlineLarge)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column{
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text("First Text", modifier = Modifier.weight(1f).background(Color.Green))
                Text("Second Text", modifier = Modifier.weight(1f).background(Color.Yellow))
                Text("Last Text", modifier = Modifier.weight(1f).background(Color.Red))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text("Third Text", modifier = Modifier.weight(1f).background(Color.Yellow))
                Text("Fourth Text", modifier = Modifier.weight(1f).background(Color.Green))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        MainScreen()
    }
}