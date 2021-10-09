package com.example.testmoxycicerone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int?,
    val login: String,
    val url: String?,
) : Parcelable
