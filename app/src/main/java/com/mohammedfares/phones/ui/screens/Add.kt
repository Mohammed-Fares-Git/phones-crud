package com.mohammedfares.phones.ui.screens

import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.PriceChange
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mohammedfares.phones.ui.MainViewModel

@Composable
fun Add(nav: NavHostController, viewModel: MainViewModel) {

    var isAdded = viewModel.addStateFlow.collectAsState()

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var rank by remember { mutableStateOf("") }
    var validName by remember { mutableStateOf(false) }
    var validPrice by remember { mutableStateOf(false) }
    var validImage by remember { mutableStateOf(false) }
    var validRank by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Arrow back icon",
                    modifier = Modifier.clickable { nav.popBackStack() })
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = name, onValueChange = {name = it}, label = {Text(text = "Name")}, leadingIcon = { Icon(
                imageVector = Icons.Filled.PhoneAndroid,
                contentDescription = "PhoneAndroid icon"
            )}, trailingIcon = {
                CheckIcon(validName)
            } )

            OutlinedTextField(value = price, onValueChange = {price = it}, label = {Text(text = "Name")}, leadingIcon = { Icon(
                imageVector = Icons.Filled.AttachMoney,
                contentDescription = "PhoneAndroid icon"
            )}, trailingIcon = {
                CheckIcon(validPrice)
            } )

            OutlinedTextField(value = image, onValueChange = {image = it}, label = {Text(text = "Name")}, leadingIcon = { Icon(
                imageVector = Icons.Filled.PhoneAndroid,
                contentDescription = "PhoneAndroid icon"
            )}, trailingIcon = {
                CheckIcon(validImage)
            } )

            OutlinedTextField(value = rank, onValueChange = {rank = it}, label = {Text(text = "Name")}, leadingIcon = { Icon(
                imageVector = Icons.Filled.PhoneAndroid,
                contentDescription = "PhoneAndroid icon"
            )}, trailingIcon = {
                CheckIcon(validRank)
            } )



            Button(onClick = {
                if (validName && validName && validPrice && validRank) {
                    viewModel.addPhone(com.mohammedfares.phones.data.Phone(name = name, price = price.toInt(), rank = rank.toInt(), image = image))
                }
            }) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
private fun CheckIcon(validName: Boolean) {
    if (validName) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "Check icon")
    } else {
        Icon(imageVector = Icons.Filled.WarningAmber, contentDescription = "WarningAmber icon")
    }
}