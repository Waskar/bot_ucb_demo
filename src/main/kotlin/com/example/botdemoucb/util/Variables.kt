package com.example.botdemoucb.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Variables {

    @Value("\${bot.telegram.username}")
    lateinit var telegramUsername: String

    @Value("\${bot.telegram.token}")
    lateinit var telegramToken: String
}