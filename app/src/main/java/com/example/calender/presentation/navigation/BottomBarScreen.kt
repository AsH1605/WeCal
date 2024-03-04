package com.example.calender.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Personal: BottomBarScreen(
        route = "Personal",
        title = "Personal",
        icon = Icons.Default.Person
    )
    object Groups: BottomBarScreen(
        route = "Groups",
        title = "Groups",
        icon = Icons.Default.MailOutline
    )
}