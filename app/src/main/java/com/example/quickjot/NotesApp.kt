package com.example.quickjot

import android.app.Application
import com.example.quickjot.di.appModule
import com.example.quickjot.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotesApp)
            modules(
                appModule,
                viewModelModule
            )
        }
    }
}
