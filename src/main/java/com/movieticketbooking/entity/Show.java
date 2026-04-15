package com.movieticketbooking.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_table")
@Getter
@Setter
public class Show {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    private LocalDate date;
    @Column(columnDefinition = "TIME")
    private LocalTime startTime;
    private double price;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Seat> seats;
}