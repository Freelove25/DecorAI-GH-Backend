package com.decoraigh.decoratorservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "decorators")
public class Decorator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String specialization;
    private Double priceMin;
    private Double priceMax;
    private Boolean available = true;
    private String contactNUmber;
    private String email;
    private String bio;
}