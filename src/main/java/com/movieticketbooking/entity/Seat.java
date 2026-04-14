package com.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "seat",
       uniqueConstraints = @UniqueConstraint(columnNames = {"show_id", "seat_number"}))
@Getter
@Setter
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