package com.example.cmedium.data

import com.example.api.CmediumClient
import com.example.api.services.CmediumAPI

object ArticlesRepo {

    val api = CmediumClient().api

    suspend fun getGlobalFeed() = api.getArticles()
}