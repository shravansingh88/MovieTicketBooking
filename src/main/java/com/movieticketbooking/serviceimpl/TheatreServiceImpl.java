package com.movieticketbooking.serviceimpl;

import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.entity.Show;
import com.movieticketbooking.repository.SeatRepository;
import com.movieticketbooking.repository.ShowRepository;
import com.movieticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Show updateShow(Long id, Show updated) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        show.setDate(updated.getDate());
        show.setStartTime(updated.getStartTime());
        show.setPrice(updated.getPrice());

        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }

@Override
    public void allocateSeats(Long showId, List<Seat> seats) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found"));

        for (Seat seat : seats) {
            seat.setShow(show);
            seat.setAvailable(false);
        }

        seatRepository.saveAll(seats);
    }
}
