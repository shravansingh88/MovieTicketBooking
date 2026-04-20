package com.movieticketbooking.controller;

import com.movieticketbooking.entity.Booking;
import com.movieticketbooking.dto.BookingRequest;
import com.movieticketbooking.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired 
    private BookingService service;

    @PostMapping
    public ResponseEntity<Booking> book(@RequestBody BookingRequest request) {
         Booking book = service.book(request);
         return ResponseEntity.ok(book);
    }

    @PostMapping
    public List<Booking> bulkBook(@RequestBody List<BookingRequest> requests) {
        return service.bulkBook(requests);
    }


    public void cancel(@PathVariable Long id) {
        service.cancelBooking(id);
    }
}