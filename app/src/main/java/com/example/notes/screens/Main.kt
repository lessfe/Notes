@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notes.screens

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.sharp.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notes.navigation.NavRoute
import com.example.notes.ui.theme.NotesTheme
import androidx.compose.material3.FloatingActionButton as FloatingActionButton



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavRoute.Add.route)
            }) {
            Icon(imageVector = Icons.Sharp.Add, contentDescription = "Add Icons")

        }
        Column(

        ) {
            noteItem(title = "Note 1", subtitle = "Sub title for note 1", navController = navController)
            noteItem(title = "Note 2", subtitle = "Sub title for note 2", navController = navController)
            noteItem(title = "Note 3", subtitle = "Sub title for note 3", navController = navController)
            noteItem(title = "Note 4", subtitle = "Sub title for note 4", navController = navController)
        }
    }
}

@Composable
fun noteItem(title: String, subtitle: String, navController: NavHostController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 80.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },


        ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
            )
            Text(

                text = subtitle,
                fontSize = 24.sp,
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    NotesTheme {
        MainScreen(navController = rememberNavController())
    }

}