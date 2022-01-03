package com.superchat.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.superchat.model.Channel;
import com.superchat.model.Contact;
import com.superchat.repository.ChannelRepository;
import com.superchat.repository.ContactRepository;
import com.superchat.util.SuperchatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ChannelRepository channelRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Transactional
    public Contact createContact(Contact contact) throws NumberParseException, IllegalArgumentException {

        SuperchatUtils.validateEmail(contact.getEmail());
        SuperchatUtils.validatePhoneNumber(contact.getPhoneNumber());

        Channel channel = channelRepository.findByName(contact.getChannel().getName());
        contact.setChannel(channel);
        return contactRepository.save(contact);
    }

    public Contact getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }
}