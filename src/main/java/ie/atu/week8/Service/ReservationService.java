package ie.atu.week8.Service;

import ie.atu.week8.errorHandler.ReservationConflictException;
import ie.atu.week8.errorHandler.ReservationNotFoundException;
import ie.atu.week8.module.Reservation;
import ie.atu.week8.repository.ReservationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations;

    private final ReservationRepo reservationRepository;

    public ReservationService(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //Create
    public Reservation addReservation(Reservation reservation){
        //everything stored in reservations
        reservations = reservationRepository.findAll();

        //Check for time conflicts
        for(Reservation existing : reservations){

            //Same equipment + same date
            if(existing.getEquipmentTag().equals(reservation.getEquipmentTag()) &&
                    existing.getReservationDate().equals(reservation.getReservationDate())){
                int existingStart = existing.getStartHour();
                int existingEnd  = existingStart + existing.getDurationHours();

                int newStart = reservation.getStartHour();
                int newEnd  = newStart + reservation.getDurationHours();
                //Overlap check
                if(existingStart < newEnd && newStart < existingEnd){
                    throw new ReservationConflictException("Time slot already booked");
                }
            }
        }
        //Add info in the database
        reservationRepository.save(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found"));
    }
}
