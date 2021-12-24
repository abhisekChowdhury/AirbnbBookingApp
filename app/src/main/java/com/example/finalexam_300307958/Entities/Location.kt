package com.example.finalexam_300307958.Entities

data class Location(
    val coordinates: List<Double>,
    val is_location_exact: Boolean,
    val type: String
)