package ie.atu.week8.controller;

import ie.atu.week8.Service.ReservationService;
import ie.atu.week8.module.Reservation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reservations")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    //Create
    @PostMapping
    public ResponseEntity<Reservation> addReservation(@Valid @RequestBody Reservation reservation){
        Reservation saved = reservationService.addReservation(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/GetAllReservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return  ResponseEntity.ok(reservationService.getAllReservations());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }
}
