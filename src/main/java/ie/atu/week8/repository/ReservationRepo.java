package ie.atu.week8.repository;

import ie.atu.week8.module.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface ReservationRepo extends JpaRepository<Reservation, Long>
{
    List<Reservation> findByReservationDate(LocalDate reservationDate);
    List<Reservation> findByReservationDateBetween(LocalDate startDate, LocalDate endDate);
    List<Reservation> findByEquipmentTagAndReservationDate(String equipmentTag, LocalDate reservationDate);
}
