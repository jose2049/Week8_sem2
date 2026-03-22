package ie.atu.week8.Service;

import ie.atu.week8.errorHandler.ReservationConflictException;
import ie.atu.week8.errorHandler.ReservationNotFoundException;
import ie.atu.week8.module.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private final List<Reservation> reservations = new ArrayList<>();
    private long nextId = 1;

    //Create
    public Reservation addReservation(Reservation reservation){

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
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations(){
        return reservations;
    }

    public Reservation getReservationById(Long id){
        for(Reservation reservation : reservations){
            if( reservation.getReservationId().equals(id) ){
                return reservation;
            }
        }
        throw new ReservationNotFoundException("Reservation not found");
    }
}
