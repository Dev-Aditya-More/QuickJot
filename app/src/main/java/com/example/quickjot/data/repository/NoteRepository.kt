package com.example.quickjot.data.repository

import com.example.quickjot.data.local.NoteDao
import com.example.quickjot.data.local.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val dao: NoteDao) {
    fun getNotes(): Flow<List<NoteEntity>> = dao.getNotes()
    suspend fun insert(note: NoteEntity) = dao.insertNote(note)
    suspend fun delete(note: NoteEntity) = dao.deleteNote(note)
}
