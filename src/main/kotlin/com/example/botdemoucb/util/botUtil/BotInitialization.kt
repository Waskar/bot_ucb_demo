package com.example.botdemoucb.util.botUtil

import com.example.botdemoucb.bl.BotBl
import com.example.botdemoucb.util.Variables
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import javax.annotation.PostConstruct

@Component
class BotInitialization
@Autowired constructor(
        private val botBl: BotBl,
        private val variables: Variables
){
    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(BotInitialization::class.java)
    }

    /**
     * Metodo para inicializar configurciones del bot
     */
    @PostConstruct
    fun initBot() {
        LOGGER.info("BOT-UTIL: Iniciando bot")
        try {
            val telegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
            telegramBotsApi.registerBot(NotificationBot(botBl, variables))
        } catch (ex: Exception) {
            LOGGER.error("BOT-UTIL-ERROR: Error al iniciar el bot, {}", ex)
        }
    }
}