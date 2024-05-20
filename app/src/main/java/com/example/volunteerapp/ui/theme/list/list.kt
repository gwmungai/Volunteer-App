package com.example.volunteerapp.ui.theme.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.volunteerapp.dashboard.VolunteerViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.volunteerapp.R
import com.example.volunteerapp.navigation.ROUTE_HOME
import com.example.volunteerapp.ui.theme.home.Event

@Composable
fun ListScreen(navController: NavController, viewModel: VolunteerViewModel = viewModel()) {
    val events by viewModel.volunteeredEvents.collectAsState(initial = emptyList())
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
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(events) { event ->
                    CardComponentWithDelete(event = event, onDeleteClick = {
                        viewModel.deleteEvent(event.id)
                    })
                }
            }
        }
    }

}
@Composable
fun CardComponentWithDelete(event: Event, onDeleteClick: () -> Unit) {
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
                painter = painterResource(id = R.drawable.check),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
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
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        onClick = onDeleteClick,
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(top = 8.dp),
                    ) {
                        Text(
                            text = "Delete",
                            color = Color.White,
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }


@Preview
@Composable
fun ListScreenPreview(){
    ListScreen(navController = rememberNavController())
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
                    painter = painterResource(id = R.drawable.check),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .background(Color.Transparent)
                        .weight(1f)
                ) {
                    Text(
                        text = "Elderly Shelter Support",
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
                            text = "12/7/2024",
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
                            text = "Kibera",
                            style = MaterialTheme.typography.body2.copy(
                                fontSize = 16.sp,
                                color = Color.Gray
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    }
                }
            }
        }



