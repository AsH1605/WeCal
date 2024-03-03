package com.example.calender.presentation.ui.component.firebaseNotes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calender.data.model.response.NoteFirebase

@Composable
fun FirebaseNotes(
    note: NoteFirebase,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp))
                    .clickable { onClick() }
                    .padding(horizontal = 8.dp, vertical = 16.dp)
            ) {
                Text(
                    text = note.note?: "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Box(
                modifier = Modifier
                    .size(35.dp) // Increase the size of the Box to accommodate the icon properly
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(6.dp) // Increase the padding to provide enough space around the icon
                    .clickable { onDelete() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    tint = MaterialTheme.colorScheme.primary, // Use MaterialTheme.colors.primary instead of MaterialTheme.colorScheme.primary
                    contentDescription = null
                )
            }
        }

        Text(
            text = note.time?:"",
            modifier = Modifier.padding(4.dp),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 10.sp
        )
    }
}
