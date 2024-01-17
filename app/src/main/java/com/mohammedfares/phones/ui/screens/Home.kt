package com.mohammedfares.phones.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mohammedfares.phones.ui.MainViewModel
import com.mohammedfares.phones.ui.Screen
import com.mohammedfares.phones.ui.components.PhoneGridList
import com.mohammedfares.phones.ui.components.PhoneRowList
import com.mohammedfares.phones.ui.components.SearchItems
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(nav: NavHostController, viewModel: MainViewModel) {

    var phones = remember {
        viewModel.phonesListMutable.value
    }

    var names = remember {
        viewModel.namesStateFlow.value
    }

    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            SearchBar(
                query = text,
                onQueryChange = {
                    text = it
                    viewModel.getNames(text)
                },
                onSearch = { active = false },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search con"
                    )
                },
                trailingIcon = {
                    if (active) Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Search con",
                        modifier = Modifier.clickable {
                            if (text.isEmpty()) {
                                active = false
                            } else {
                                text = ""
                            }
                        }
                    )
                }
            ) {
                SearchItems(names = names)
            }
        },
        content = {
                  Column (modifier = Modifier
                      .fillMaxSize()
                      .padding(it)){
                      PhoneRowList(nav = nav, phones = phones)
                      Divider(
                          modifier = Modifier
                              .fillMaxWidth()
                              .padding(vertical = 8.dp),
                          color = Color.Gray,
                          thickness = 1.dp
                      )
                      PhoneGridList(nav = nav, phones = phones)
                  }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate(Screen.add.route) }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            }
        }
    )
}