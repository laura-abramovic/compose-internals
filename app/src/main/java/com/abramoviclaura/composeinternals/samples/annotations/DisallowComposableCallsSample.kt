package com.abramoviclaura.composeinternals.samples.annotations

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls


@Composable
fun DisallowComposableCallsSample() {
    Text("Hello")

    performAction {
        Log.d("Action log", "Allowed call ")
    }
}

@Composable
fun performAction(action: @DisallowComposableCalls () -> Unit) {
    action()
}
