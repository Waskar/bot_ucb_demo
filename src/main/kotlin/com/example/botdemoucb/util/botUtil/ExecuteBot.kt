package com.example.botdemoucb.util.botUtil

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

class ExecuteBot {

    companion object {
        @JvmStatic
        fun executeSendMessage(
                sendMessage: SendMessage,
                notificationBot: NotificationBot
        ): Boolean {
            return try {
                notificationBot.execute(sendMessage)
                true
            } catch (ex: Exception) {
                ex.stackTrace
                false
            }
        }
    }
}