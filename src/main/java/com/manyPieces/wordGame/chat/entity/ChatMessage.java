package com.manyPieces.wordGame.chat.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chatMessage")
@EntityListeners(AuditingEntityListener.class)
public class ChatMessage {

    @Id
    private String id;

    private MessageType type;

    private String roomId;

    private String sender;

    private String message;

    @CreatedDate
    private LocalDateTime createdAt;

    public enum MessageType {
        ENTER, TALK
    }
}