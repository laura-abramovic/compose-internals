package com.abramoviclaura.composeinternals.samples.restarting

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RestartingScreen() {
    NoInlineColumn()

    SideEffect {
        Log.d("Composable restarted", "RestartingScreen")
    }
}

@Composable
fun NoInlineColumn() {
    var counter by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextSection("Count: $counter")

        Spacer(Modifier.height(24.dp))

        ButtonSection(onClick = { ++counter })

        SideEffect {
            Log.d("Composable restarted", "Column")
        }
    }
}

@Composable
fun TextSection(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium
    )

    SideEffect {
        Log.d("Composable restarted", "TextSection")
    }
}

@Composable
fun ButtonSection(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Increase counter")

        SideEffect {
            Log.d("Composable restarted", "Button")
        }
    }

    SideEffect {
        Log.d("Composable restarted", "ButtonSection")
    }
}
