package com.movieticketbooking.service;

import com.movieticketbooking.dto.ShowDTO;

import java.time.LocalDate;
import java.util.List;

public interface ShowService  {
List<ShowDTO> browse(String movie, String city, LocalDate date);
}
