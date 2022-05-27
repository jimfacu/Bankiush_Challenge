package com.example.bankiushchallenge.Models.MainScreen

import android.os.Parcelable
import com.example.bankiushchallenge.Models.DetailScreen.Owner
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(val id:Int,val name:String,val full_name:String,val watchers:Int,val visibility:String,
val owner: Owner):Parcelable
