
package com.decoraigh.decoratorservice.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long decoratorId;
    private String eventDate;
    private String venue;
    private Double budget;
    private String status;
    private String eventType;
    private String notes;
}