package com.ubaya.a160419111_kost_uts.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
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
){
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}



