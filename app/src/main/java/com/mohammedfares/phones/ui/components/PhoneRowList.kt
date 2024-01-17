package com.mohammedfares.phones.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mohammedfares.phones.data.Phone

@Composable
fun PhoneGridList() {

}


@Preview
@Composable
fun PhoneGridListPreview(nav: NavHostController, phones: List<Phone>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content ={
        itemsIndexed(phones) {index, item ->
            PhoneGridItem(nav = nav, phone = item)
        }
    })
}