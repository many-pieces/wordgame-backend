package com.manyPieces.wordGame.chat.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "chatRoom")
@EntityListeners(AuditingEntityListener.class)
public class ChatRoom {

    @Id
    private String Id;
    private String name;

    public ChatRoom(String name) {
        this.name = name;
    }
}