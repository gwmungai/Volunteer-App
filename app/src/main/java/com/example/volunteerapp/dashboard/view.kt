package com.example.volunteerapp.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.volunteerapp.ui.theme.home.Event
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VolunteerViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _volunteeredEvents = MutableStateFlow<List<Event>>(emptyList())
    val volunteeredEvents: StateFlow<List<Event>> = _volunteeredEvents.asStateFlow()

    init {
        fetchVolunteeredEvents()
    }

    fun addEvent(event: Event) {
        viewModelScope.launch {
            db.collection("events")
                .add(event)
                .addOnSuccessListener { documentReference ->
                    fetchVolunteeredEvents()
                }
                .addOnFailureListener { e ->
                }
        }
    }

    fun deleteEvent(eventId: String) {
        viewModelScope.launch {
            db.collection("events").document(eventId)
                .delete()
                .addOnSuccessListener {
                    fetchVolunteeredEvents()
                }
                .addOnFailureListener { e ->
                }
        }
    }

    private fun fetchVolunteeredEvents() {
        db.collection("events")
            .get()
            .addOnSuccessListener { result ->
                val events = result.map { document ->
                    document.toObject(Event::class.java).copy(id = document.id)
                }
                _volunteeredEvents.value = events
            }
            .addOnFailureListener { e ->
            }
    }
}