package rentalapp.dto;

import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.sql.Time;
import java.sql.Timestamp;

@Data
public class RentalDTO {
    private int id;
    private Timestamp start;
    private Timestamp end;

    private Point startLocation;
    private Point endLocation;
    private Time duration;

    private String identificationCard;
    private String driverLicence;

    private int clientId;
    private int vehicleId;
}
