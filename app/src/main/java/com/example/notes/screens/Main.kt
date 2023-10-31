@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.notes.screens
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
/*import androidx.compose.runtime.livedata.observeAsState*/
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notes.MainViewModel
import com.example.notes.model.Note
/*import com.example.notes.model.Note*/
import com.example.notes.navigation.NavRoute
import androidx.compose.material3.FloatingActionButton as FloatingActionButton
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val context = LocalContext.current
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Sharp.Add,
                    contentDescription = "Add Icons"
                )
            }
        }
    ) {
        LazyColumn{
            items(notes) {note -> NoteItem(note = note, navController = navController) }
        }
    }
}
@Composable
fun NoteItem(note: Note, navController: NavHostController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 80.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route + "/${note.id}")
            },

        ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontSize = 24.sp,
            )
            Text(
                text = note.subtitle,
                fontSize = 24.sp,
            )
        }
    }
}

