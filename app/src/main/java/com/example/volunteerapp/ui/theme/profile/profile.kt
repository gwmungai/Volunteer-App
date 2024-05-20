package com.example.volunteerapp.ui.theme.profile


import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R
import android.content.Intent
import android.net.Uri
import com.example.volunteerapp.navigation.ROUTE_ABOUTUS
import com.example.volunteerapp.navigation.ROUTE_LOGIN
import com.example.volunteerapp.navigation.ROUTE_SETTINGS


@Composable
fun ProfileScreen( navController: NavHostController) {
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
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ConstraintLayout() {
                val (topIng, user) = createRefs()
                Image(painter = painterResource(id = R.drawable.moon),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .padding(start = 0.dp, end = 0.dp)
                        .clip(RoundedCornerShape(bottomStart = 230.dp, bottomEnd = 230.dp))
                        .constrainAs(topIng) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        })
                Image(painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    Modifier
                        .clip(CircleShape)
                        .size(150.dp)
                        .constrainAs(user) {
                            top.linkTo(topIng.bottom)
                            bottom.linkTo(topIng.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        })
            }
            Text(
                text = "Username",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(top = 10.dp),
                color = Color.DarkGray
            )
            Text(
                text = "Email",
                fontSize = 25.sp,
                fontWeight = FontWeight.Light,
                color = Color.DarkGray
            )
            Button(
                onClick = { navController.navigate(ROUTE_ABOUTUS) },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(20)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(50.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.design_ic_accessibility),
                        contentDescription = "settings",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {}
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(2f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "About Us",
                        color = Color.DarkGray,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Button(
                onClick = {
                    val uri = Uri.parse("https://support.google.com/")
                    val intent = Intent(Intent.ACTION_VIEW, uri) },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(20)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(50.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.design_ic_help),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {}
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(2f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Help",
                        color = Color.DarkGray,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Button(
                onClick = { navController.navigate(ROUTE_SETTINGS) },
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(20)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(50.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.design_ic_settings),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {}
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(2f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Settings",
                        color = Color.DarkGray,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            Button(
                onClick = { navController.navigate(ROUTE_LOGIN)},
                Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, top = 10.dp, bottom = 10.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                shape = RoundedCornerShape(20)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .height(50.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.design_ic_logout),
                        contentDescription = "settings",
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .clickable {}
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(2f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Log Out",
                        color = Color.DarkGray,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController())
}