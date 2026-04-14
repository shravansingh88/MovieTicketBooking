package com.movieticketbooking.controller;

import com.movieticketbooking.dto.ShowDTO;
import com.movieticketbooking.service.ShowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired 
    private ShowService service;

    @GetMapping
    public List<ShowDTO> browse(
            @RequestParam String movie,
            @RequestParam String city,
            @RequestParam String date) {

        return service.browse(movie, city, LocalDate.parse(date));
    }
}