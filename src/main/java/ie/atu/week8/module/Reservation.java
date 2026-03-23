package ie.atu.week8.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @NotNull(message = "Reservation Tag must be entered")
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
