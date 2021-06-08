package com.cmedium.api

import com.example.api.CmediumClient
import junit.framework.Assert.assertNotNull
import org.junit.Test

class CmediumClientTests {

    private val cmediumClient = CmediumClient()

    @Test
    fun`GET articles`(){

       val articles = cmediumClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)

    }
}