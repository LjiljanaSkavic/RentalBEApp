package rentalapp.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Point {
    private Double lat;
    private Double lng;
}
