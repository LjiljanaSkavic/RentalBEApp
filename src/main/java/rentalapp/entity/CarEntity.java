package rentalapp.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class CarEntity extends VehicleEntity {

    @Basic
    @Column(name = "acquisition_date")
    private Timestamp acquisitionDate;

    @Basic
    @Column(name = "description")
    private String description;
}
