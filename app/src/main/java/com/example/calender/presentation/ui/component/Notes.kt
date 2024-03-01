package com.example.calender.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calender.data.db.NoteEntity

@Composable
fun Notes(
    noteEntity: NoteEntity, onClick: () -> Unit, onDelete: () -> Unit
){
    Box(modifier = Modifier.fillMaxSize()) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopCenter),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(androidx.compose.ui.graphics.Color.Companion.White)
        ){
            Column (
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ){
//                Text(
//                    text = "Shared with all",
//                    modifier = Modifier.align(Alignment.Start),
//                    style = TextStyle(
//                        fontSize = 10.sp,
//                        color = MaterialTheme.colorScheme.primary,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//                Divider(modifier = Modifier.fillMaxWidth())
                Text(
                    text = "hello guys!",
                    modifier = Modifier.align(Alignment.Start),
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Note",
                    modifier = Modifier.size(20.dp).align(Alignment.End)
                )
            }
        }
    }
}