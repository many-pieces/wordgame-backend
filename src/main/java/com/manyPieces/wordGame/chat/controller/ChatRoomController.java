package com.manyPieces.wordGame.chat.controller;

import com.manyPieces.wordGame.chat.entity.ChatRoom;
import com.manyPieces.wordGame.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoom>> room() {

        List<ChatRoom> rooms = chatRoomService.findAllChatRoom();

        return ResponseEntity.status(HttpStatus.OK).body(rooms);
    }

    @PostMapping("/room")
    public ResponseEntity<String> createRoom(@RequestBody Map<String, String> map) {

        chatRoomService.create(map.get("name"));

        return ResponseEntity.status(HttpStatus.OK).body("채팅방 생성 완료!");
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<ChatRoom> roomInfo(@PathVariable String roomId) throws NoSuchObjectException {

        ChatRoom chatRoom = chatRoomService.findChatRoom(roomId);

        return ResponseEntity.status(HttpStatus.OK).body(chatRoom);
    }
}