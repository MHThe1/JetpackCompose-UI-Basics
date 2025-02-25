package com.kotlintut.firstapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
                .background(Color.LightGray)
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text("Cards",
                style = MaterialTheme.typography.headlineLarge)
        }

        Spacer(modifier = Modifier.height(10.dp))

        SimpleCard()
        ImageCard()
        ClickableCard()
        StyledCard()

    }
}


@Composable
fun SimpleCard() {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "This is a simple Card",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Composable
fun ImageCard() {
    val context = LocalContext.current
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.my_image),
                contentDescription = "My Image",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "This is a Image Card",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            Button(
                onClick = {Toast.makeText(context, "Click me button was clicked!", Toast.LENGTH_SHORT).show()},
                modifier = Modifier.padding(4.dp)
            ) {
                Text("Click me!")
            }
        }
    }
}


@Composable
fun ClickableCard() {
    val context = LocalContext.current
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = { Toast.makeText(context, "Clickable Card clicked!", Toast.LENGTH_SHORT).show() }),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Text(
            text = "Clickable Card",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }

}

@Composable
fun StyledCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Cyan),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Text(
            text = "Styled Card",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstAppTheme {
        MainScreen()
    }
}