package starome.backend.starome.entities;

import java.util.Set;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be empty")
    @Size(min = 5, max = 80, message = "Name must be between 20 and 20 characters long")
    private String name;

    @NotNull(message = "Description cannot be empty")
    @NotNull(message = "Age limit cannot be empty")
    @Min(value = 0, message = "Age limit must be a positive number")
    @Max(value = 16, message = "Age limit must be less than 16")
    private int ageLimit;

    @NotNull(message = "Price per hour cannot be empty")
    @Min(value = 0, message = "Price per hour must be a positive number")
    private int priceHr;

    @Nullable
    @Min(value = 0, message = "Price per day must be a positive number")
    private int priceDay;

    private boolean isSpecial;

    @OneToMany(mappedBy = "service")
    private Set<Caregiver> bookings;
}
