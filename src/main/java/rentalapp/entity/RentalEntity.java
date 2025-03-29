package rentalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "lat", column = @Column(name = "start_location_lat")),
            @AttributeOverride(name = "lng", column = @Column(name = "start_location_lng"))
    })
    private Point startLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "lat", column = @Column(name = "end_location_lat")),
            @AttributeOverride(name = "lng", column = @Column(name = "end_location_lng"))
    })
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private UserEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private VehicleEntity vehicle;

}
