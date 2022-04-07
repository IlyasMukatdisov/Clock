package com.gmail.mukatdisovilyas.clock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gmail.mukatdisovilyas.clock.ui.theme.ClockTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            ClockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Clock()
                }
            }
        }
    }
}

@Composable
fun Clock()
{
    val sdf = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
    var currentDate by remember {
        mutableStateOf(sdf.format(Date()))
    }
    LaunchedEffect(key1 = true) { // this: CoroutineScope
        while (true)
        {
            delay(1000L)
            currentDate = sdf.format(Date())
        }
    }

    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = currentDate, fontSize = 40.sp)
    }
}

/*
@Composable
fun Greeting(name: String)
{
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview()
{
    ClockTheme {
        Greeting("Android")
    }
}*/
