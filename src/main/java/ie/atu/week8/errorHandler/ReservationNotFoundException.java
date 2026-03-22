package ie.atu.week8.errorHandler;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String reservationNotFound)
    {
        super(reservationNotFound);
    }
}
