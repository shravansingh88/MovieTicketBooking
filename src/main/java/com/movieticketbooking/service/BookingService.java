package com.movieticketbooking.service;

import com.movieticketbooking.dto.BookingRequest;
import com.movieticketbooking.entity.Booking;

public interface BookingService{
    Booking book(BookingRequest request);
}