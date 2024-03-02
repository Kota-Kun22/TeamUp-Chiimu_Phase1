package com.example.lottieanimation_splashscreen.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.text.font.FontFamily
import com.example.lottieanimation_splashscreen.R
import com.example.lottieanimation_splashscreen.presentation.SignInViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(viewModel: SignInViewModel = viewModel(), state: SignInState) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val signInState = viewModel.signInState.collectAsState(initial = null).value
    val regularFont = FontFamily.SansSerif

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Enter your credentials to Log In",
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
                disabledLabelColor = Color.LightGray,
                unfocusedIndicatorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent
            ), shape = RoundedCornerShape(9.dp),
            singleLine = true,
            placeholder = { Text(text = "Email") } )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                cursorColor = Color.Black,
                disabledLabelColor = Color.LightGray,
                unfocusedIndicatorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent
            ), shape = RoundedCornerShape(9.dp),
            singleLine = true,
            placeholder = { Text(text = "Password") } )

        Button(
            onClick = {
                scope.launch {
                    viewModel.loginUser(email, password)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Sign In", color = Color.White, modifier = Modifier.padding(7.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (state.isLoading) {
                CircularProgressIndicator()
            }
        }

        Text(text = "Don't have an Account? Sign up", fontWeight = FontWeight.Bold, color = Color.Black, fontFamily = regularFont)
    }

    Text(text = "or connect with", fontWeight = FontWeight.Medium, color = Color.Black)


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(50.dp),
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_fb),
                contentDescription = "FaceBook Icon",
                modifier = Modifier.size(50.dp),
                tint = Color.Unspecified
            )
        }

        LaunchedEffect(key1 = state.isSuccess) {
            scope.launch {
                if (state.isSuccess?.isNotEmpty() == true) {
                    val success = state.isSuccess
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                }
            }
        }

        LaunchedEffect(key1 = state.isError) {
            scope.launch {
                if (state.isError?.isNotEmpty() == true) {
                    val error = state.isError
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
