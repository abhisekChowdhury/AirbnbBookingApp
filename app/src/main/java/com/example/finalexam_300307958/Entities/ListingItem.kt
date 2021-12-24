package com.example.finalexam_300307958.Entities

data class ListingItem(
    //val _id: String,
    val accommodates: Int,
    //val bathrooms: Double,
    val bedrooms: Int,
    val beds: Int,
    val description: String,
    val listing_url: String,
    val maximum_nights: String,
    val minimum_nights: String,
    val name: String,
    val property_type: String,
    val space: String,
    val summary: String,
    val amenities: List<String>,
    val address: AddressX,
    val bathrooms: Bathrooms
)