package rentalapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class MalfunctionRequest {
    private Date date;
    private String time;
    private String description;
    private boolean isDeleted;
    private Integer vehicleId;
}
