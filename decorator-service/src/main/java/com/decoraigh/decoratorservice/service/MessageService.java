package com.decoraigh.decoratorservice.service;

import com.decoraigh.decoratorservice.entity.Message;
import com.decoraigh.decoratorservice.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByBooking(Long bookingId) {
        return messageRepository.findByBookingId(bookingId);
    }

    public List<Message> getConversation(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}