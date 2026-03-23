package ie.atu.week8.repository;

import ie.atu.week8.module.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {

}
