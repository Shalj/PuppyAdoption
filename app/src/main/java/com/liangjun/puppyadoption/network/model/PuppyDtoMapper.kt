package com.liangjun.puppyadoption.network.model

import com.liangjun.puppyadoption.domain.mapper.DomainMapper
import com.liangjun.puppyadoption.domain.model.Puppy

class PuppyDtoMapper : DomainMapper<PuppyDto, Puppy> {
    override fun mapToDomainModel(model: PuppyDto): Puppy {
        return Puppy(
            id = model.id,
            name = model.name ?: "little poor guy",
            age = model.age ?: 0,
            featuredImage = model.featuredImage ?: "",
            createTime = model.createTime ?: "unknown",
            adopted = model.adopted ?: false,
            breed = model.breed ?: "unknown",
            gender = model.gender ?: "unknown",
            brief = model.brief ?: ""
        )
    }

    fun toDomainList(list: List<PuppyDto>): List<Puppy> {
        return list.map { mapToDomainModel(it) }
    }
}