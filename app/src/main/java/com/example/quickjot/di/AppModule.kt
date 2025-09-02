package com.example.quickjot.di

import androidx.room.Room
import com.example.quickjot.data.local.NoteDB
import com.example.quickjot.data.repository.NoteRepository
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), NoteDB::class.java, "notes.db")
            .fallbackToDestructiveMigration(false)
            .build()
    }
    single { get<NoteDB>().noteDao() }
    single { NoteRepository(get()) }
}