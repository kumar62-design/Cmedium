package com.cmedium.api

import com.example.api.CmediumClient
import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class CmediumClientTests {

    private val cmediumClient = CmediumClient()

    @Test
    fun`GET articles`(){

        runBlocking {
            val articles = cmediumClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun`GET articles by author`(){

        runBlocking {
            val articles = cmediumClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }
    @Test
    fun`GET articles by tags`(){

        runBlocking {
            val articles = cmediumClient.api.getArticles(tag = "dragons")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `POST users - create user`(){
          val userCreds =  UserCreds(
                email = "testemail${Random.nextInt(999,9999)}@test.com",
                password = "pass${Random.nextInt(9999,999999)}",
                username = "rand_user_${Random.nextInt(99,999)}"
            )

        runBlocking {
            val resp = cmediumClient.api.signupUser(SignupRequest(userCreds))
            assertEquals(userCreds.username,resp.body()?.user?.username)
        }
    }

















}