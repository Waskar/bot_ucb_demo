package com.example.botdemoucb.util.botUtil

import com.example.botdemoucb.bl.BotBl
import com.example.botdemoucb.util.Variables
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class NotificationBot(
        private val botBl: BotBl,
        private val variables: Variables
): TelegramLongPollingBot() {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(NotificationBot::class.java)
    }

    /**
     * Recibir el token de telegram del bot
     */
    override fun getBotToken(): String {
        return variables.telegramToken
    }

    override fun getBotUsername(): String {
        return variables.telegramUsername
    }

    /**
     * Aqui recibes los mensajes
     */
    override fun onUpdateReceived(p0: Update?) {
        LOGGER.info("Recibir mensaje: {}", p0)
        botBl.notification("Hola como estas?")
        botBl.saludar()
    }

}