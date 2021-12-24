package com.example.finalexam_300307958

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalexam_300307958.Entities.UserItem
import com.example.finalexam_300307958.Entities.ListingItem
import com.example.finalexam_300307958.Retrofit.RetroInstance
import com.example.finalexam_300307958.Retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentMainViewModel : ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<ListingItem>?>
    lateinit var userLiveData: MutableLiveData<UserItem?>

    init {
        liveDataList = MutableLiveData()
        userLiveData = MutableLiveData()
    }

    fun backendListingsList() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getalllistings()
        call.enqueue(object : Callback<List<ListingItem>> {
            override fun onFailure(call: Call<List<ListingItem>>, t: Throwable) {
                Log.i("error",t.message.toString())
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<ListingItem>>,
                response: Response<List<ListingItem>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }

    fun backendSearchListingsList(accommodates:Int,bedrooms:Int,beds:Int,minimum_nights:String,maximum_nights:String,bathrooms: String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getSearchedListing(accommodates,bedrooms,beds,minimum_nights,maximum_nights,bathrooms)
        call.enqueue(object : Callback<List<ListingItem>> {
            override fun onFailure(call: Call<List<ListingItem>>, t: Throwable) {
                Log.i("error",t.message.toString())
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<ListingItem>>,
                response: Response<List<ListingItem>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }

    fun backendfinduser(Username:String) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.finduser(Username)
        call.enqueue(object : Callback<UserItem> {
            override fun onFailure(call: Call<UserItem>, t: Throwable) {
                userLiveData.postValue(null)
            }

            override fun onResponse(
                call: Call<UserItem>,
                response: Response<UserItem>
            ) {
                userLiveData?.postValue(response.body())
            }
        })
    }



    fun backendAddUser(body: UserItem) {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.adduser(body)
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i("failure to add user ","failed")
            }

            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                //liveBikeAppViewModel.insertListOfUsers(response.body()!!)
                //Log.i("response add user ", "aaaaa")
                //Log.i("Data: ", (response.body() as SingleUserEntity?).toString())
            }
        })
    }
}