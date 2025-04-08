package rentalapp.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class MalfunctionDTO {
    private Integer id;
    private Date date;
    private Time time;
    private String description;
    private boolean isDeleted;
    private Integer vehicleId;
}