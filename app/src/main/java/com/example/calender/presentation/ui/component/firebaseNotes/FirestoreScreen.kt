package com.example.calender.presentation.ui.component.firebaseNotes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.calender.data.model.NoteFirebase
import com.example.calender.presentation.viewmodel.NotesFirebaseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirestoreScreen(
    firebaseNotes: List<NoteFirebase>,
    viewModel: NotesFirebaseViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ){
    val (dialogOpen, setDialogOpen) = remember {
        mutableStateOf(false)
    }

    if(dialogOpen){
        val (note, setNote) = remember {
            mutableStateOf("")
        }
        Dialog(onDismissRequest = { setDialogOpen(false) }) {
            Column{
                OutlinedTextField(
                    value = note,
                    onValueChange = {setNote(it)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Note", color = Color.White) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        focusedLabelColor = MaterialTheme.colorScheme.primary,
                        cursorColor = Color.White,
                        focusedTextColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(18.dp))
                Button(onClick = {
                    if (note.isNotEmpty()){
                        viewModel.addNote(note)
                        setDialogOpen(false)
                    }
                },
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(text = "Save for all", color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { setDialogOpen(true) },
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {paddings->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = firebaseNotes.isEmpty(),
                enter = scaleIn() + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                Text(text = "No Notes shared with all", color = Color.White, fontSize = 22.sp)
            }
            AnimatedVisibility(
                visible = firebaseNotes.isNotEmpty(),
                enter = scaleIn() + fadeIn(),
                exit = scaleOut() + fadeOut()
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = paddings.calculateBottomPadding() + 8.dp,
                            top = 8.dp,
                            start = 8.dp,
                            end = 8.dp,
                        ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(firebaseNotes) { note->
                        Note(
                            note = note,
                            onClick = { /*TODO*/ },
                            onDelete = { note.id?.let { viewModel.deleteNotek(it) } }
                        )
                    }
                }
            }
        }
    }
}
