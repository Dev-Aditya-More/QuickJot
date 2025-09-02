package com.example.quickjot.di

import com.example.quickjot.ui.screens.NotesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NotesViewModel(get()) }
}
