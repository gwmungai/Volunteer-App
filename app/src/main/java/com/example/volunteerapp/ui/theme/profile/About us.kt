package com.example.volunteerapp.ui.theme.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R

@Composable
fun AboutUsScreen(navController: NavController) {
    Box(
        modifier = Modifier
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
                text = "About Us",
                color =Color(0xff0FB06A),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .size(400.dp)
                    .background(Color.Transparent)
                    .border(
                        width = 4.dp,
                        color = Color(0xff0FB06A),
                        shape = RoundedCornerShape(28.dp),
                    )
            ){
            Text(
                text = "Volunteer App is dedicated to connecting volunteers with meaningful opportunities to contribute to their communities." +
                        "It also benefits organizations by simplifying the recruitment and coordination of volunteers." +
                        "Thereby ensuring that more resources are directed towards achieving their missions thus the app fosters community engagement.",
                style = MaterialTheme.typography.displaySmall,
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp, start = 9.dp, end = 4.dp)
            )}
            Spacer(modifier = Modifier
                .padding(bottom = 15.dp))

            Column (
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
            ){

                Text(
                    text = "Contact Us",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(bottom = 8.dp, top = 2.dp)
                )
                ContactInfo("Phone", "+1234567890")
                ContactInfo("Email", "contact@volunteerapp.com")
                ContactInfo("Address", "Volunteer St, City, Country")

            }
            Divider(
                color = Color.Black,
                thickness = 4.dp,
                modifier = Modifier
                    .padding()
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xff0FB06A),)
                    .padding(bottom = 2.dp)
            ){
                Text(
                    text = "For any inquiries or feedback, please email us at info@volunteerapp.com",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic

                )
            }
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String) {
    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .width(100.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelLarge,
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AboutUsPreview(){
    AboutUsScreen(rememberNavController())
}