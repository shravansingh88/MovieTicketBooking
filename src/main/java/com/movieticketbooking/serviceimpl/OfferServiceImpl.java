package com.movieticketbooking.serviceimpl;

import com.movieticketbooking.service.OfferService;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class OfferServiceImpl implements OfferService {

    @Override
    public double calculatePrice(int tickets, double price, LocalTime time) {

        double total = tickets * price;

        // 50% discount on 3rd ticket
        total -= (tickets / 3) * (price * 0.5);

        // Afternoon discount
        if (time.isAfter(LocalTime.NOON) && time.isBefore(LocalTime.of(17, 0))) {
            total *= 0.8;
        }

        return total;
    }
}