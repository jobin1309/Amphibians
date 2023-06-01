package com.example.amphibians.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Amphibian(
     var id:Int,
     var name: String,
     var type: String,
     var description: String
): Parcelable{
}