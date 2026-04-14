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

    public ShowDTO(String theatreName, LocalTime time, long availableSeats) {
        this.theatreName = theatreName;
        this.time = time;
        this.availableSeats = availableSeats;
    }
}