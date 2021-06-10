package com.example.cmedium.data

import com.example.api.CmediumClient

object ArticlesRepo {

    val api = CmediumClient.publicApi
    val authApi = CmediumClient.authApi

    suspend fun getGlobalFeed() = api.getArticles()
    suspend fun getMyFeed() = api.getFeedArticles()
}