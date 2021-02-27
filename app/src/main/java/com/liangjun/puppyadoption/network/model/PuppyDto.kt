package com.liangjun.puppyadoption.network.model

import com.google.gson.annotations.SerializedName

data class PuppyDto(
    val age: Int?,
    @SerializedName("create_time")
    val createTime: String?,
    @SerializedName("featured_image")
    val featuredImage: String?,
    val name: String?,
    @SerializedName("pk")
    val id: String,
    val adopted :Boolean?,
    val breed :String?,
    val gender :String?,
    val brief :String?
)