package com.movieticketbooking.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowRequest {

    private Long movieId;

    private Long theatreId;

    private LocalDate date;

    private LocalTime startTime;

    private Double price;
}