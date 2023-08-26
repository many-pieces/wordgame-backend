package com.manyPieces.wordGame.chat.repository;

import com.manyPieces.wordGame.chat.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<ChatMessage, String> {


}
