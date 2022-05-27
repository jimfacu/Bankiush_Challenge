package com.example.bankiushchallenge.Models.DetailScreen

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Owner (val login:String,val id:Int):Parcelable{
}