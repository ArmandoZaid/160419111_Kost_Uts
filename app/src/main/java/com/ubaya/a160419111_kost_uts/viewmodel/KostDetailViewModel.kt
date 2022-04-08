package com.ubaya.a160419111_kost_uts.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.ubaya.a160419111_kost_uts.model.Kost

class KostDetailViewModel(application: Application) : AndroidViewModel(application) {
    val kostLD = MutableLiveData<Kost>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun fetch(id:String?){

    }
}