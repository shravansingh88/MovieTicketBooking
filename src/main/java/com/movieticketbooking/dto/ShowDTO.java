package com.movieticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ShowDTO {
    private String theatreName;
    private LocalTime time;
    private long availableSeats;
}