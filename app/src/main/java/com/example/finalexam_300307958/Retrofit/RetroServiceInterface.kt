package com.example.finalexam_300307958.Retrofit

import com.example.finalexam_300307958.Entities.UserItem
import com.example.finalexam_300307958.Entities.ListingItem
import retrofit2.Call
import retrofit2.http.*

interface RetroServiceInterface {

    @GET("getalllistings")
    fun getalllistings(): Call<List<ListingItem>>

    @POST("adduser")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun adduser(@Body params: UserItem):Call<Any>

    @GET("finduser/{username}")
    fun finduser(
        @Path("username") Username: String
    ): Call<UserItem>

    @GET("getSearchedListing/{accommodates}/{bedrooms}/{beds}/{minimum_nights}/{maximum_nights}/{bathrooms}")
    fun getSearchedListing(
        @Path("accommodates") accommodates: Int,
        @Path("bedrooms") bedrooms: Int,
        @Path("beds") beds: Int,
        @Path("minimum_nights") minimum_nights: String,
        @Path("maximum_nights") maximum_nights: String,
        @Path("bathrooms") bathrooms: String
    ): Call<List<ListingItem>>



//    @GET("getallbikes")
//    fun getallbikes(): Call<List<BikeEntity>>
//
//    @GET("getallbikes1")
//    fun getallbikes1(): Call<List<SingleBikeEntity>>
//
//    @GET("getbikedescription/{id}")
//    fun getbikedescription(
//        @Path("id") id: String
//    ): Call<BikeEntity>
//
//    @POST("adduser")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun adduser(@Body params: SingleUserEntity):Call<Any>
//
//    @POST("addbike")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun addbike(@Body params: SingleBikeEntity):Call<Any>
//
//    @GET("findusernamepassword/{username}")
//    fun findusernamepassword(
//        @Path("username") UserName: String
//    ): Call<UserEntity>
//
//    @GET("findbookingbyusername/{username}")
//    fun findbookingbyusername(
//        @Path("username") UserName: String
//    ): Call<BookingHistoryEntity>
//
//    @POST("addbookinghistory")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun addbookinghistory(@Body params: SingleBookingHistoryEntity):Call<Any>
}