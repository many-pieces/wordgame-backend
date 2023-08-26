package com.manyPieces.wordGame.chat.service;

import com.manyPieces.wordGame.chat.entity.ChatRoom;
import com.manyPieces.wordGame.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAllChatRoom() {

        List<ChatRoom> rooms = chatRoomRepository.findAll();

        return rooms;
    }

    public void create(String name) {

        ChatRoom chatRoom = new ChatRoom(name);

        chatRoomRepository.save(chatRoom);
    }

    public ChatRoom findChatRoom(String roomId) throws NoSuchObjectException {

        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new NoSuchObjectException("존재하지 않는 roomId 입니다"));

        return chatRoom;
    }
}
