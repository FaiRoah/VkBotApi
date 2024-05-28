package com.fairoah.vkbotapi.service

import com.fairoah.vkbotapi.controller.BotController
import com.fairoah.vkbotapi.model.MessageDto
import com.squareup.okhttp.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.random.Random


@Service
class BotService (@Value("\${vk.accessToken}") val vkAccessToken: String){

    private val logger = LoggerFactory.getLogger(BotController::class.java)

    val apiVersion: Double = 5.236

    fun repeatText(
        messageDto: MessageDto,
    ) {
        val randomNumber = Random.nextInt()
        val client = OkHttpClient()


        val url = HttpUrl.Builder()
            .scheme("https")
            .host("api.vk.com")
            .addPathSegment("method")
            .addPathSegment("messages.send")
            .addQueryParameter("access_token", vkAccessToken)
            .addQueryParameter("user_id", messageDto.from_id.toString())
            .addQueryParameter("random_id", randomNumber.toString())
            .addQueryParameter("message", "Вы сказали: " + messageDto.text)
            .addQueryParameter("v", apiVersion.toString())
            .build()

        val request = Request.Builder()
            .url(url)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(request: Request?, e: IOException) {
                logger.error("Request failed: $request.")
                e.printStackTrace()
            }

            override fun onResponse(response: Response) {
                if (!response.isSuccessful){
                    logger.error("Response is unsuccessful: $response")
                    throw IOException("Unexpected code $response")
                }
            }

        })
    }
}