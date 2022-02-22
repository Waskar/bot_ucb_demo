package com.example.botdemoucb.api

import com.example.botdemoucb.bl.BotBl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notification")
class NotificationController
@Autowired constructor(
        private val botBl: BotBl
)
{
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(NotificationController::class.java)
    }

    @RequestMapping(
            method = [RequestMethod.POST])
    fun notificationUser(@RequestParam message: String): ResponseEntity<*> {
        LOGGER.info("Iniciando proceso de envio del mensaje")
        val data = botBl.notification(message)
        return ResponseEntity(data, HttpStatus.OK)
    }
}