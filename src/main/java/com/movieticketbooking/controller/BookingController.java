package com.movieticketbooking.controller;

import com.movieticketbooking.entity.Booking;
import com.movieticketbooking.dto.BookingRequest;
import com.movieticketbooking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired 
    private BookingService service;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return service.book(request);
    }
}