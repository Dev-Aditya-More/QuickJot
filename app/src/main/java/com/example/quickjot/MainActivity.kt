package com.example.quickjot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quickjot.ui.screens.AddNoteScreen
import com.example.quickjot.ui.screens.NotesScreen
import com.example.quickjot.ui.screens.NotesViewModel
import com.example.quickjot.ui.theme.QuickJotTheme
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickJotTheme {
                val navController = rememberNavController()

                AppNavHost(Modifier, navController)
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(navController, startDestination = "notes") {
        composable("notes") {
            NotesScreen(
                onAddNoteClick = { navController.navigate("add") }
            )
        }
        composable("add") {
            AddNoteScreen(
                onNoteSaved = { navController.popBackStack() }
            )
        }
    }
}
