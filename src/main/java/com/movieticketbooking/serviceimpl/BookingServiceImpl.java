package com.movieticketbooking.serviceimpl;

import com.movieticketbooking.service.BookingService;

import com.movieticketbooking.dto.BookingRequest;
import com.movieticketbooking.entity.Booking;
import com.movieticketbooking.Seat;
import com.movieticketbooking.Show;
import com.movieticketbooking.repository.BookingRepository;
import com.movieticketbooking.repository.ShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired private ShowRepository showRepo;
    @Autowired private BookingRepository bookingRepo;
    @Autowired private OfferService offerService;

    @Override
    @Transactional
    public Booking book(BookingRequest request) {

        Show show = showRepo.findById(request.getShowId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        List<Seat> seats = show.getSeats().stream()
                .filter(s -> request.getSeatIds().contains(s.getId()) && s.isAvailable())
                .toList();

        if (seats.size() != request.getSeatIds().size()) {
            throw new RuntimeException("Seats unavailable");
        }

        seats.forEach(s -> s.setAvailable(false));

        double total = offerService.calculatePrice(
                seats.size(),
                show.getPrice(),
                show.getStartTime()
        );

        Booking booking = new Booking();
        booking.setShow(show);
        booking.setSeats(seats);
        booking.setTotalAmount(total);

        return bookingRepo.save(booking);
    }
}