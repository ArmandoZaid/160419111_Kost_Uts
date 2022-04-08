package com.ubaya.a160419111_kost_uts.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.a160419111_kost_uts.model.Kost

class KostDetailViewModel(application: Application) : AndroidViewModel(application) {
    val kostLD = MutableLiveData<Kost>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun fetch(id:String?){


    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}