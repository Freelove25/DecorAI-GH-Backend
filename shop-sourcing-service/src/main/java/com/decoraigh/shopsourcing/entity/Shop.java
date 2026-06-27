package com.decoraigh.shopsourcing.entity;

import jakarta.persistence.*;
import lombok.Data;

    @Data
    @Entity
    @Table(name = "shops")
    public class Shop {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String ownerName;
        private String location;
        private String category;
        private String contactNumber;
        private String email;
        private Double radiusKm;
        private Double rating;
        private String stockDescription;
        private boolean verified;
    }

