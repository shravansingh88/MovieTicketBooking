package com.movieticketbooking.serviceimpl;

import com.movieticketbooking.dto.ShowDTO;
import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.repository.ShowRepository;
import com.movieticketbooking.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository repo;

    @Override
    public List<ShowDTO> browse(String movie, String city, LocalDate date) {

        return repo.findByMovie_NameAndTheatre_CityAndDate(movie, city, date)
                .stream()
                .map(s -> new ShowDTO(
                        s.getTheatre().getName(),
                        s.getStartTime(),
                        s.getSeats().stream().filter(Seat::isAvailable).count()
                ))
                .toList();
    }
}