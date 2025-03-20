package rentalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class VehicleSearchResult {
    private List<VehicleDTO> vehicles;
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public VehicleSearchResult(List<VehicleDTO> vehicles, long totalElements, int totalPages, int pageNumber, int pageSize) {
        this.vehicles = vehicles;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
