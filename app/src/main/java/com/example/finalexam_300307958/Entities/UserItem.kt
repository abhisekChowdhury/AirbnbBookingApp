package com.example.finalexam_300307958.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class UserItem(
    val Username: String,
    val Firstname: String,
    val Lastname: String,
    val User_id: Int
    //val _id: Id,

)

//@Entity(tableName = "SingleUserEntity")
//data class SingleUserEntity(
//    @PrimaryKey(autoGenerate = false)
//    @SerializedName("FullName")val FullName: String,
//    @SerializedName("UserName")val UserName: String,
//    @SerializedName("Address")val Address: String,
//    @SerializedName("Password")val Password: String
//)