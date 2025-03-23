package rentalapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "malfunction", schema = "rentaldb", catalog = "")
public class MalfunctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Basic
    @Column(name = "vehicle_id")
    private int vehicleId;

}
