package com.example.semesterproject.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.semesterproject.navigation.Routes
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AccountView(navController: NavHostController = rememberNavController()){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.DarkGray)
            .padding(10.dp)
    ){
        LoginCard(navController)
        CreateAccountCard(navController)
    }
}

@Composable
fun LoginCard(navController: NavHostController) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Login", fontSize =20.sp)
            val username = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = username.value,
                onValueChange = {username.value = it},
                placeholder = { Text(text = "Username") },
                modifier = Modifier.padding(10.dp)
            )

            val pass = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = pass.value,
                onValueChange = {pass.value = it},
                placeholder = { Text(text = "Password") },
                modifier = Modifier.padding(10.dp)
            )

            Button(
                onClick = {navController.navigate(Routes.MainMenu.route) },
                modifier = Modifier.padding(10.dp)
                ) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
fun CreateAccountCard(navController: NavHostController) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Create an Account", fontSize =20.sp)
            val username = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = username.value,
                onValueChange = {username.value = it},
                placeholder = { Text(text = "Chose a Username") },
                modifier = Modifier.padding(10.dp)
            )

            val pass = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = pass.value,
                onValueChange = {pass.value = it},
                placeholder = { Text(text = "Choose a Password") },
                modifier = Modifier.padding(10.dp)
            )

            val passConfirm = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = passConfirm.value,
                onValueChange = {passConfirm.value = it},
                placeholder = { Text(text = "Confirm Password") },
                modifier = Modifier.padding(10.dp)
            )

            Button(
                // TODO: make this button create an account then log in
                onClick = {navController.navigate(Routes.MainMenu.route)},
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Submit")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun LoginPre(){
    AccountView()
}