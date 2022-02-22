package com.example.botdemoucb.bl

import com.example.botdemoucb.util.Variables
import com.example.botdemoucb.util.botUtil.ExecuteBot.Companion.executeSendMessage
import com.example.botdemoucb.util.botUtil.NotificationBot
import com.example.botdemoucb.util.botUtil.SendMessageInit.Companion.initSendMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BotBl
@Autowired constructor(
        private val variables: Variables
){
    companion object {
        private var LOGGER: Logger = LoggerFactory.getLogger(BotBl::class.java)
    }

    /**
     * Método para que envie mensajes
     */
    fun notification(message: String): String {
        LOGGER.info("BL: Iniciando proceso de envio del mensaje")
        executeSendMessage(initSendMessage("chat_id", message),
                NotificationBot(this, variables))
        return "Se notifico al usuario"
    }
    fun saludar() {

    }
}