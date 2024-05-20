package com.example.volunteerapp.ui.theme.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R

@Composable
fun SettingsScreen(navController: NavController) {
    var darkThemeEnabled by remember { mutableStateOf(false) }
    Box (modifier = Modifier
        .background(Color.White)
        .fillMaxSize(),
    contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(1500.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xff0FB06A),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))

            Switch(
                checked = darkThemeEnabled,
                onCheckedChange = { darkThemeEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.secondary,
                    checkedTrackColor = MaterialTheme.colors.secondaryVariant
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Dark Theme",
                style = MaterialTheme.typography.body1,
                color = Color(0xff0FB06A),
                fontSize = 20.sp
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreenPreview(){
    SettingsScreen(rememberNavController())
}