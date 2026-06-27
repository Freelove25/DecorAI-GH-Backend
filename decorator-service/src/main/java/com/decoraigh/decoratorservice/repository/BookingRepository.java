package com.decoraigh.decoratorservice.repository;

import com.decoraigh.decoratorservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByClientId(Long clientId);
    List<Booking> findByDecoratorId(Long decoratorId);
    List<Booking> findByStatus(String status);
}