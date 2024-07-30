package com.adhi.moviecrud.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun BottomNavigation(navController: NavController) {
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar {
        NavigationBarItem(selected = selectedItem == 0,
            onClick = {
                navController.navigate("home")
                selectedItem = 0
            }, icon = {
                Icon(
                    imageVector = Icons.TwoTone.Home,
                    contentDescription = "Home"
                )
            })
        NavigationBarItem(selected = selectedItem == 1,
            onClick = {
                navController.navigate("new")
                selectedItem = 1
            }, icon = {
                Icon(
                    imageVector = Icons.TwoTone.Add,
                    contentDescription = "Add"
                )
            })
    }
}