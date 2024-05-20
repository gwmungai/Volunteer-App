package com.example.volunteerapp.ui.theme.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R
import com.example.volunteerapp.dashboard.VolunteerViewModel
import com.example.volunteerapp.navigation.ROUTE_LIST

@Composable
fun HomeScreen(navController: NavController, viewModel: VolunteerViewModel = viewModel()) {
    val images = listOf(
        R.drawable.tree,
        R.drawable.blood,
        R.drawable.wildlife,
        R.drawable.elderly,
        R.drawable.beach,
        R.drawable.food,
        R.drawable.firstaid
    )
    val events = listOf(
        Event("Tree Planting Initiative", "2/6/2024", "", "Karura Forest"),
        Event("Blood Donation Drive", "14/6/2024", "", "Uhuru Park"),
        Event("Wildlife Conservation Workshop", "23/5/2024", "", "KWS Headquarters"),
        Event("Elderly Shelter Support ", "12/7/2024", "", "Kibera"),
        Event("Park Cleanup Campaign", "14/5/2024", "", "Watamu,Mombasa"),
        Event("Soup Kitchen Volunteer", "13/6/2024", "", "Mombasa Rd"),
        Event("First Aid Training ", "6/7/2024", "", "Red Cross HQ")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background), // Replace with your background image
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(1500.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 15.dp)
                    .height(20.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(
                    text = "Home",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(events.size) { index ->
                val event = events[index]
                val image = images[index % images.size]

                CardComponent(
                    event = event,
                    image = image,
                    onVolunteerClick = {
                    viewModel.addEvent(event)
                    navController.navigate(ROUTE_LIST)
                    }
                )
            }
        }
    }
}

@Composable
fun CardComponent(event: Event, image: Int, onVolunteerClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.Transparent),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .background(Color.Transparent)
                    .weight(1f)
            ) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.h6.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(bottom = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date Icon",
                        tint = Color.Gray
                    )
                    Text(
                        text = event.date,
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(bottom = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location Icon",
                        tint = Color.Gray
                    )
                    Text(
                        text = event.location,
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFF2DC080)),
                    onClick = onVolunteerClick,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(top = 8.dp),
                ) {
                    Text(text = "Volunteer",
                        color = Color.White,
                        fontSize = 17.sp)
                }
            }
        }
    }
}

data class Event(
    val title: String,
    val date: String,
    val time: String,
    val location: String,
    val id : String = ""
)


@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}


