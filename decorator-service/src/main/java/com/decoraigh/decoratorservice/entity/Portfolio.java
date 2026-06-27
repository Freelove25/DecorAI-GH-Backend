package com.decoraigh.decoratorservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long decoratorId;
    private String imageUrl;
    private String eventType;
    private String description;
}