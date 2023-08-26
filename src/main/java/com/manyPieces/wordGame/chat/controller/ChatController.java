package com.manyPieces.wordGame.chat.controller;

import com.manyPieces.wordGame.chat.service.ChatService;
import com.manyPieces.wordGame.chat.entity.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat")
    public void message(ChatMessage message) {

        chatService.sendMessage(message);
    }
}