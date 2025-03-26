package rentalapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rental", schema = "rentaldb", catalog = "")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "start")
    private Timestamp start;

    @Basic
    @Column(name = "end")
    private Timestamp end;

    @Basic
    @Column(name = "start_location", columnDefinition = "POINT")
    private Point startLocation;

    @Basic
    @Column(name = "end_location", columnDefinition = "POINT")
    private Point endLocation;

    @Basic
    @Column(name = "duration")
    private Time duration;

    @Basic
    @Column(name = "identification_card")
    private String identificationCard;

    @Basic
    @Column(name = "driver_licence")
    private String driverLicence;

    @Basic
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "vehicle_id")
    private int vehicleId;
}
