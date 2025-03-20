package rentalapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import rentalapp.enums.VehicleStatus;

@Data
@Entity
@Table(name = "vehicle", schema = "rentaldb")
@Inheritance(strategy = InheritanceType.JOINED)
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "vehicle_code")
    private String vehicleCode;

    @Basic
    @Column(name = "purchase_price")
    private double purchasePrice;

    @Basic
    @Column(name = "model")
    private String model;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VehicleStatus status;

    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Basic
    @Column(name = "manufacturer_id")
    private int manufacturerId;

    @Basic
    @Column(name = "vehicle_picture_id")
    private int vehiclePictureId;
}
