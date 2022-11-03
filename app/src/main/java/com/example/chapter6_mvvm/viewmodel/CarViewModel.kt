package com.example.chapter6_mvvm.viewmodel

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter6_mvvm.model.DataCarItem
import com.example.chapter6_mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarViewModel : ViewModel() {

    var liveDataListCar : MutableLiveData<List<DataCarItem>> = MutableLiveData()

    fun getLiveDataCar(): MutableLiveData<List<DataCarItem>> {
        return liveDataListCar
    }

    fun callApiCar() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<DataCarItem>> {
                override fun onResponse(
                    call: Call<List<DataCarItem>>,
                    response: Response<List<DataCarItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataListCar.postValue(response.body())
                    } else {
                        liveDataListCar.postValue(null!!)
                    }
                }
                override fun onFailure(call: Call<List<DataCarItem>>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message} ", )
                }

            })
    }
}