package com.liangjun.puppyadoption.domain.mapper

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
}