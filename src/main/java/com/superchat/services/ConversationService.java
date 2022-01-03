package com.superchat.services;

import com.superchat.dto.MessageDto;
import com.superchat.model.Contact;
import com.superchat.model.Conversation;
import com.superchat.model.User;
import com.superchat.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll(Sort.by("id"));
    }

    public Conversation createNewConversation(MessageDto messageDto) {
        Conversation conversation = new Conversation();
        Contact contact = contactService.getContactById(messageDto.getContactId());
        conversation.setContact(contact);
        conversation.setStartDate(Timestamp.from(Instant.now()));
        User user = userService.findByUserId(messageDto.getUserId());
        conversation.setUser(user);
        return conversation;
    }

    public void saveConversation(Conversation conversation) {
        conversationRepository.save(conversation);
    }

    @Transactional
    public void endConversation(Long conversationId) {
        Optional<Conversation> conversation = conversationRepository.findById(conversationId);
        conversation.ifPresent(value -> value.setEndDate(Timestamp.from(Instant.now())));
    }
}