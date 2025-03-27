package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "car")
public class CarEntity extends VehicleEntity {

    @Basic
    @Column(name = "acquisition_date")
    private LocalDate acquisitionDate;

    @Basic
    @Column(name = "description")
    private String description;
}
