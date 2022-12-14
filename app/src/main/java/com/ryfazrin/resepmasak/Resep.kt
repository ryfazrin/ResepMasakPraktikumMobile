package com.ryfazrin.resepmasak

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resep(
    var resep_title: String,
    var times: String,
    var difficulty: String,
    var avatar: Int,
    var description: String
) : Parcelable
