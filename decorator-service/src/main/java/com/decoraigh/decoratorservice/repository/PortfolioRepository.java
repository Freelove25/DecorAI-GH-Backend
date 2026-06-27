package com.decoraigh.decoratorservice.repository;

import com.decoraigh.decoratorservice.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByDecoratorId(Long decoratorId);
    List<Portfolio> findByEventType(String eventType);
}