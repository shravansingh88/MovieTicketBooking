package com.movieticketbooking.service;

import java.time.LocalTime;

public interface OfferService{
    double calculatePrice(int tickets, double price, LocalTime time);
}