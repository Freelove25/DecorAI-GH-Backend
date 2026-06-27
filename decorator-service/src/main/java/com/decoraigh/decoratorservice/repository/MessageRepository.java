package com.decoraigh.decoratorservice.repository;

import com.decoraigh.decoratorservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
    List<Message> findByBookingId(Long bookingId);
}