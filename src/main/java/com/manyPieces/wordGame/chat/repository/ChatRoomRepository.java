package com.manyPieces.wordGame.chat.repository;

import com.manyPieces.wordGame.chat.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

}