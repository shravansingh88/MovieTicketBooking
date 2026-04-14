package com.movieticketbooking.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "theater")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> shows;
}