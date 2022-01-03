package com.superchat.dto;

import com.superchat.model.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDto {
    private Message message;
    private Long contactId;
    private Long userId;
    private Long conversationId;
}