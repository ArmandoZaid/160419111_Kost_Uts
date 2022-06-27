package com.ubaya.a160419111_kost_uts.model

import com.google.gson.annotations.SerializedName

data class Kost(
    val id:String?,
    @SerializedName("student_name")
    val nama:String?,
    val jenis:String?,
    val harga:String?,
    val fasilitas:String?,
    @SerializedName("photo_url")
    val foto:String?,
    val alamat:String?,
    val komen:String?,
    val rating:String?
)



