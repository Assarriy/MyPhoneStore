package com.assarriy.myphonestore

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(
    val name: String,
    val price: String,
    val description: String,
    val photo: Int
):Parcelable
