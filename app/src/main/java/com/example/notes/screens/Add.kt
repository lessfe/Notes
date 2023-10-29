@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.notes.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.notes.navigation.NavRoute

@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController) {
    var title by rememberSaveable { mutableStateOf("")}
    var subtitle by rememberSaveable { mutableStateOf("")}
    Scaffold {
        Column(

            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = "Add new note",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            OutlinedTextField(
                value = title,
                onValueChange = { subtitle = it },
                label = { Text("Note title") }
            )

            OutlinedTextField(
                value = subtitle,
                onValueChange = { subtitle = it.toString() },
                label = {Text("Note subtitle")}
            )
            Button(
                modifier = Modifier.padding(top = 16.dp),
                onClick = {
                    navController.navigate(route = NavRoute.Main.route)
                }
            ) {

            }

        }
    }

}