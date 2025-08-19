package com.abramoviclaura.composeinternals.samples.positionalmemoization

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key

data class Item(val id: Int)

@Composable
fun PositionalMemoizationScreen() {
    Column {
        Text("Hello")
        Text("Hello")
        Text("Hello")
    }

    val items = List(5, { Item(it) })

    Column {
        items.forEach {
            key(it.id) {
                Text("Hello again")
            }
        }
    }
}
