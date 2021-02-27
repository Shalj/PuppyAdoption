package com.liangjun.puppyadoption.network.mock

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liangjun.puppyadoption.network.model.PuppyDto

fun getPuppyData() = """
    [
    {"pk":"0","name":"Mitchy","age":2,"featured_image":"https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=0d3f33fb6aa6e0154b7713a00454c83d","create_time":"2021-02-26 20:17:13","breed":"unknown","gender":"male","favourite":"balls", "adopted":false, "brief":"A dog who stayed by his owner's side for two days after he became trapped in the snow and died has found a new home to call his own."},
    {"pk":"1","name":"Doge","age":3,"featured_image":"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/gettyimages-1094874726.png?crop=0.542xw:0.814xh;0.0472xw,0.127xh&resize=640:*","create_time":"2021-02-26 20:17:13","breed":"unknown","gender":"male","favourite":"balls", "adopted":true, "brief":"no more information"},
    {"pk":"2","name":"Peaye","age":1,"featured_image":"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*","create_time":"2021-02-26 20:17:13","breed":"unknown","gender":"male","favourite":"balls", "adopted":false, "brief":"no more information"},
    {"pk":"3","name":"Sett","age":4,"featured_image":"https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg","create_time":"2021-02-26 20:17:13","breed":"unknown","gender":"male","favourite":"balls", "adopted":false, "brief":"no more information"}
    ]
""".trimIndent()

fun getPuppyDetailById(id: String): PuppyDto {
    val puppies = Gson().fromJson<List<PuppyDto>>(
        getPuppyData(),
        object : TypeToken<List<PuppyDto>>() {}.type
    )
    //ensure the puppy does exist
    return puppies.find { it.id == id }!!
}