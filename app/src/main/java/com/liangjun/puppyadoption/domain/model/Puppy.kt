package com.liangjun.puppyadoption.domain.model

data class Puppy(
    val id: String,
    val name: String,
    val age: Int,
    val featuredImage: String,
    val createTime: String,
    val adopted: Boolean,
    val breed: String,
    val gender: String,
    val brief: String
)
