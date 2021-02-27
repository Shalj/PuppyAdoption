package com.liangjun.puppyadoption.repository

import com.liangjun.puppyadoption.domain.model.Puppy


interface PuppyRepository {

    suspend fun getList(): List<Puppy>

    suspend fun getPuppyDetail(id: String): Puppy
}