package com.superchat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "text")
    @NotNull
    private String text;

    @Column
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "id")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Conversation conversation;

    @OneToOne
    @JoinColumn(name = "message_sender_id", referencedColumnName = "id")
    @NotNull
    private MessageSender sender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(timestamp, message.timestamp) && Objects.equals(conversation, message.conversation) && Objects.equals(sender, message.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, conversation, sender);
    }
}