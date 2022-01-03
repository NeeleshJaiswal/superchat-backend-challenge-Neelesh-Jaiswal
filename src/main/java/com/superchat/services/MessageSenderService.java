package com.superchat.services;

import com.superchat.model.MessageSender;
import com.superchat.repository.MessageSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    @Autowired
    private MessageSenderRepository messageSenderRepository;

    public MessageSender findByType(String type) {
        return messageSenderRepository.findByType(type);
    }
}