package com.movieticketbooking.service;

import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.entity.Show;

import java.util.List;

public interface TheatreService {

    Show createShow(Show show);
    Show updateShow(Long id, Show updated);
    void deleteShow(Long id);
    void allocateSeats(Long showId, List<Seat> seats);
}
