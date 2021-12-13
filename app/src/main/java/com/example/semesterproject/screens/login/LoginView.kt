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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.semesterproject.navigation.Routes
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AccountView(
    navController: NavHostController = rememberNavController(),
    signIn: (String) -> Unit,
    vm: LoginViewModel
) {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.DarkGray)
            .padding(10.dp)
    ) {

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
                    onClick = {
                        signIn(username.value.text)
                        navController.navigate(Routes.MainMenu.route)
                              },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Login")
                }
            }
        }

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
            ) {
                Text(text = "Create an Account", fontSize = 20.sp)
                val username = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    placeholder = { Text(text = "Chose a Username") },
                    modifier = Modifier.padding(10.dp)
                )

                val pass = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = pass.value,
                    onValueChange = { pass.value = it },
                    placeholder = { Text(text = "Choose a Password") },
                    modifier = Modifier.padding(10.dp)
                )

                val passConfirm = remember { mutableStateOf(TextFieldValue()) }
                TextField(
                    value = passConfirm.value,
                    onValueChange = { passConfirm.value = it },
                    placeholder = { Text(text = "Confirm Password") },
                    modifier = Modifier.padding(10.dp)
                )

                val openDialog = remember { mutableStateOf(false)  }
                var message = remember { mutableStateOf("")}
                Button(
                    onClick = {
                        if (
                            pass.value.text == passConfirm.value.text
                            && pass.value.text != ""
                        ) {
                            vm.addUser(username.value.text, passConfirm.value.text)
                            username.value = TextFieldValue("")
                            pass.value = TextFieldValue("")
                            passConfirm.value = TextFieldValue("")
                            message.value = "Account Created! You can now login and start playing!"
                            openDialog.value = true
                        }
                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Submit")
                }
                if (openDialog.value) {
                    AlertDialog(
                        onDismissRequest = { openDialog.value = false },
                        title = { Text(message.value)},
                        confirmButton = {
                            Button(
                                onClick = { openDialog.value = false }) {
                                Text("Close")
                            }
                        }
                    )
                }
            }
        }
    }
}
