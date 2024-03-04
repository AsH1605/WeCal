package com.example.calender.data.RepositoryImpl

import com.example.calender.data.model.NoteFirebase
import com.example.calender.data.model.response.ResponseFromFirestore
import com.example.calender.domain.NotesFirebase.DeleteNoteResponse
import com.example.calender.domain.NotesFirebase.NotesFirebaseRepository
import com.example.calender.domain.NotesFirebase.addNoteResponse
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteFromFirebaseRepositoryImpl @Inject constructor(
    private val noteRef: CollectionReference
): NotesFirebaseRepository{

    override fun getNotesFromFirestore() = callbackFlow {
        val snapshotListener = noteRef.orderBy("id").addSnapshotListener { snapshot, e ->
            val notesResponse = if (snapshot!=null){
                val note = snapshot.toObjects(NoteFirebase::class.java)
                ResponseFromFirestore.Success(note)
            } else{
                ResponseFromFirestore.Failure(e)
            }
            trySend(notesResponse)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }

    override suspend fun addNoteToFirestore(note: String): addNoteResponse = try {
        val id = noteRef.document().id
        val notes = NoteFirebase(
            id = id,
            note = note
        )
        noteRef.document(id).set(notes).await()
        ResponseFromFirestore.Success(true)
    } catch (e:Exception){
        ResponseFromFirestore.Failure(e)
    }

    override suspend fun deleteNoteFromFirebase(id: String): DeleteNoteResponse= try {
        noteRef.document(id).delete().await()
        ResponseFromFirestore.Success(true)
    } catch (e:Exception){
        ResponseFromFirestore.Failure(e)
    }
}