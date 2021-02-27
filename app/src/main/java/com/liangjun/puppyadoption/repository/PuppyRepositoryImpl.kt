package com.liangjun.puppyadoption.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liangjun.puppyadoption.domain.model.Puppy
import com.liangjun.puppyadoption.network.mock.getPuppyData
import com.liangjun.puppyadoption.network.mock.getPuppyDetailById
import com.liangjun.puppyadoption.network.model.PuppyDto
import com.liangjun.puppyadoption.network.model.PuppyDtoMapper
import dagger.hilt.InstallIn

class PuppyRepositoryImpl(private val mapper: PuppyDtoMapper) : PuppyRepository {
    override suspend fun getList(): List<Puppy> {
        //pretending fetching data from network
        val result = Gson().fromJson<List<PuppyDto>>(
            getPuppyData(),
            object : TypeToken<List<PuppyDto>>() {}.type
        )
        return mapper.toDomainList(result)
    }

    override suspend fun getPuppyDetail(id: String): Puppy {
        //pretending fetching data from network
        return mapper.mapToDomainModel(getPuppyDetailById(id))
    }
}