package com.kotlintut.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlintut.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),

                    floatingActionButton = {
                        ExtFab()
                    }

                    ) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("FAB",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary)
        }

        Spacer(modifier = Modifier.height(10.dp))

//        FabExample()
//        FabSmall()
//        FabLarge()
        DummyList()
//        ExtFab()
    }
}


@Composable
fun FabExample() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Red,
        contentColor = Color.White,
        shape = RectangleShape
    ) {
        Icon(Icons.Default.Add, "Add")
    }
}

@Composable
fun FabSmall() {
    SmallFloatingActionButton(
        onClick = {}
    ) {
        Icon(Icons.Default.Info, "small")
    }
}

@Composable
fun FabLarge() {
    LargeFloatingActionButton(
        onClick = {}
    ) {
        Icon(Icons.Default.Email, "Big FAB")
    }
}

@Composable
fun ExtFab() {
    ExtendedFloatingActionButton(
        onClick = {},
        icon = {Icon(Icons.Default.Build, "Ext FAB")},
        text = {Text("Extended")}
    )
}


@Composable
fun DummyList() {
    LazyColumn {
        items(100) {
            item -> Text("Item $item")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    FirstAppTheme {
        MainScreen()
    }
}