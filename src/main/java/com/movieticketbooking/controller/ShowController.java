package com.movieticketbooking.controller;

import com.movieticketbooking.dto.ShowDTO;
import com.movieticketbooking.entity.Seat;
import com.movieticketbooking.entity.Show;
import com.movieticketbooking.service.ShowService;

import com.movieticketbooking.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired 
    private ShowService service;

    @Autowired
    private TheatreService theatreService;

    @GetMapping
    public List<ShowDTO> browse(
            @RequestParam String movie,
            @RequestParam String city,
            @RequestParam String date) {

        return service.browse(movie, city, LocalDate.parse(date));
    }

    @PostMapping("/new-show")
    public ResponseEntity<Show> createShow(@RequestBody Show show) {
        Show savedShow = theatreService.createShow(show);
        return ResponseEntity.ok(savedShow);
    }

    @PutMapping("/update-show/{id}")
    public ResponseEntity<Show> updateShow(
            @PathVariable Long id,
            @RequestBody Show updatedShow) {

        Show show = theatreService.updateShow(id, updatedShow);
        return ResponseEntity.ok(show);
    }

    @DeleteMapping("/delete-show/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable Long id) {
        theatreService.deleteShow(id);
        return ResponseEntity.ok("Show deleted successfully");
    }

    @PostMapping("/allocate-seats/{showId}")
    public ResponseEntity<String> allocateSeats(
            @PathVariable Long showId,
            @RequestBody List<Seat> seats) {

        theatreService.allocateSeats(showId, seats);
        return ResponseEntity.ok( "Seats allocated successfully");
    }
}