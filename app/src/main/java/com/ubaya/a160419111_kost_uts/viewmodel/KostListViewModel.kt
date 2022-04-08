package com.ubaya.a160419111_kost_uts.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.a160419111_kost_uts.model.Kost

class KostListViewModel(application: Application) : AndroidViewModel(application) {
    val kostLD = MutableLiveData<ArrayList<Kost>>()
    val kostLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun refresh(){
        kostLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.1.13/listkost.json"

        val stringRequest = StringRequest(
            Request.Method.GET,url,{
                val sType = object : TypeToken<ArrayList<Kost>>(){}.type
                val result = Gson().fromJson<ArrayList<Kost>>(it,sType)
                kostLD.value = result
                loadingLD.value = false
                Log.d("showvolley",it)
            },
            {
                loadingLD.value = false
                kostLoadErrorLD.value = true
                Log.d("errorvolley",it.toString())
            }
        ).apply {
            tag = "TAG"
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}