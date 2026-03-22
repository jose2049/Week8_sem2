package ie.atu.week8.module;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Reservation {

    @NotBlank(message = "Reservation Tag must be entered")
    private Long reservationId;

    @NotBlank(message = "Reservation Tag must be entered")
    private Long reservationTag;

    @NotBlank(message= "Equipment Tag is required")
    private String equipmentTag;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull(message  = "Please enter a date")
    private LocalDate reservationDate;

    @Min(value = 0, message = "Duration time should be between 0 and 23")
    @Max(value = 23, message = "Duration time should be between 0 and 23")
    private int startHour;

    @Min(value = 1, message = "Duration time should be between 1 and 24")
    @Max(value = 24, message = "Duration time should be between 1 and 24")
    private int durationHours;
}
