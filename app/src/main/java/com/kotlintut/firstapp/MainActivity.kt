package com.kotlintut.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlintut.firstapp.ui.theme.FirstAppTheme
import kotlinx.coroutines.launch

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
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("SnackBar",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onPrimary)
        }

        Spacer(modifier = Modifier.height(10.dp))

        NameScreen()

    }
}


//@Composable
//fun SnackBarExample() {
//    val snackbarHostState = remember { SnackbarHostState() }
//    val coroutineScope = rememberCoroutineScope()
//
//    Column (
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Button(onClick = {
//            coroutineScope.launch {
//                snackbarHostState.showSnackbar("This is a snackbar!")
//            }
//        }) {
//            Text("Show Snackbar")
//        }
//    }
//    SnackbarHost(hostState = snackbarHostState)
//}




@Composable
fun NameScreen() {

    var name by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NameInput(name = name, onNameChange = { name = it })
        Greeting(name = name)
    }
}

@Composable
fun NameInput(name: String, onNameChange: (String) -> Unit) {

    var tempName by rememberSaveable { mutableStateOf(name) }

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    TextField(
        value = tempName,
        onValueChange = { tempName = it },
        label = { Text("Enter your name") }
    )
    Button(
        modifier = Modifier
            .padding(top = 10.dp),
        onClick = { onNameChange(tempName) }) {
        Text("Confirm Name")
    }

    if(name.isNotEmpty()) {
        Button(onClick = {
            onNameChange("")
            coroutineScope.launch {
                val result = snackbarHostState.showSnackbar(
                    message = "Name deleted!",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Short
                )
                if(result == SnackbarResult.ActionPerformed) {
                    onNameChange(name)
                }
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )) {
            Text("Delete name!")
        }
    }

    SnackbarHost(hostState = snackbarHostState)

}

@Composable
fun Greeting(name: String) {
    if(name.isNotEmpty()){
        Text(
            text = "Hi $name!",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.displayLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    FirstAppTheme {
        MainScreen()
    }
}