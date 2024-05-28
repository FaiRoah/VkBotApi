package com.fairoah.vkbotapi.controller

import com.fairoah.vkbotapi.model.EventDto
import com.fairoah.vkbotapi.service.BotService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
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

    private val logger = LoggerFactory.getLogger(BotController::class.java)

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

        val eventDto: EventDto
        try {
            eventDto = objectMapper.readValue(body)
        } catch (e: Exception) {
            logger.error("Error parsing request body: $body", e)
            return ResponseEntity.status(HttpStatus.OK).body("ok")
        }

        return try {
            if (eventDto.type == "message_new") {
                val message = eventDto.`object`?.message
                if (message != null) {
                    logger.info("New message: $message")
                    botService.repeatText(message)
                } else {
                    logger.error("Got new message but it's null. ")
                }
            }
            ResponseEntity.status(HttpStatus.OK).body("ok")
        } catch (e: RuntimeException) {
            logger.error("Error repeating message: ${eventDto.`object`?.message}", e)
            ResponseEntity.status(HttpStatus.OK).body("ok")
        }

    }


}