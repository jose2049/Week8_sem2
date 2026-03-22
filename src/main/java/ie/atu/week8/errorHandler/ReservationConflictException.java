package ie.atu.week8.errorHandler;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String timeSlotAlreadyBooked)
    {
        super(timeSlotAlreadyBooked);
    }
}
