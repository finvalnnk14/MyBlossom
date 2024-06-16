package com.example.myblossom.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class ArticleModel(
    var image : String? = null,
    var title : String? = null,
    val content : String? = null,
    val source : String? = null,
) : Parcelable