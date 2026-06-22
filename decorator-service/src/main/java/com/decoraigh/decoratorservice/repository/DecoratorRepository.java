package com.decoraigh.decoratorservice.repository;

import com.decoraigh.decoratorservice.entity.Decorator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DecoratorRepository extends JpaRepository<Decorator, Long> {

    List<Decorator> findByLocation(String location);

    List<Decorator> findBySpecialization(String specialization);

    List<Decorator> findByAvailable(Boolean available);
}