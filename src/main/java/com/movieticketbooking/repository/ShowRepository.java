package com.movieticketbooking.repository;

import com.movieticketbooking.entity.Show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovie_NameAndTheatre_CityAndDate(
        String movie, String city, LocalDate date);
}