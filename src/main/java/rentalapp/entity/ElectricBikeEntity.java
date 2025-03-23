package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "electric_bike")
public class ElectricBikeEntity extends VehicleEntity {
    @Basic
    @Column(name = "range_per_charge")
    private Integer rangePerCharge;
}
