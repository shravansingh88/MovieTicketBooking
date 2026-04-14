package com.movieticketbooking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat",
       uniqueConstraints = @UniqueConstraint(columnNames = {"show_id", "seat_number"}))
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private Boolean available = true;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
}