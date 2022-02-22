package com.example.botdemoucb.util.botUtil

import org.telegram.telegrambots.meta.api.methods.send.SendMessage

class SendMessageInit {
    companion object {
        @JvmStatic
        fun initSendMessage(chatId: String, text: String): SendMessage{
            val message = SendMessage()
            message.enableMarkdown(true)
            message.chatId = chatId
            message.text = text
            return message
        }
    }
}