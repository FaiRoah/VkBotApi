package com.fairoah.vkbotapi.controller

import com.fairoah.vkbotapi.model.EventDto
import com.fairoah.vkbotapi.service.BotService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class BotController {


    private lateinit var botService: BotService

    @Autowired
    fun setMyService(botService: BotService) {
        this.botService = botService
    }

    @Value("\${serverVerification.code}")
    lateinit var serverVerificationCode: String

    @PostMapping("/callback")
    fun verifyServer(@RequestBody body: String): ResponseEntity<String> {
        val objectMapper = jacksonObjectMapper()

        return try {
            val eventDto: EventDto = objectMapper.readValue(body)
            if (eventDto.type == "message_new") {
                println(eventDto)   // TODO добавить логирование
                botService.repeatText(eventDto.`object`?.message!!)
            }
            ResponseEntity.status(HttpStatus.OK).body("ok")
        } catch (e: Exception) {
            e.printStackTrace()
            ResponseEntity.status(HttpStatus.OK).body("ok")
        }

    }


}