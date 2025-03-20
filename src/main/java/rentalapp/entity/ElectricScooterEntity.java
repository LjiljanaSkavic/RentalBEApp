package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ElectricScooterEntity extends VehicleEntity {
    @Basic
    @Column(name = "max_speed")
    private Integer maxSpeed;
}
