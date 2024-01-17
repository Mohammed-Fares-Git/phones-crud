package com.mohammedfares.phones.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammedfares.phones.data.Phone

@Composable
fun SearchItems(names: List<String>) {
    names.forEach {
        Row (modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Filled.History, contentDescription = "History icon", modifier = Modifier.padding(end = 10.dp))
            Text(text = it, fontSize = 20.sp)
        }
    }
}