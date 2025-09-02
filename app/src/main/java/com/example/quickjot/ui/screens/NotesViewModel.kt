package com.example.quickjot.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickjot.data.local.NoteEntity
import com.example.quickjot.data.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NotesViewModel(private val repo: NoteRepository) : ViewModel() {
    val notes: StateFlow<List<NoteEntity>> =
        repo.getNotes().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addDummyNote() {
        viewModelScope.launch {
            repo.insert(NoteEntity(title = "New Note", content = "Content"))
        }
    }
}
