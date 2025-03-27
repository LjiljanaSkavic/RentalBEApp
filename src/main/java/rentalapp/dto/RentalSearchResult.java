package rentalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class RentalSearchResult {
    private List<RentalDTO> rentals;
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public RentalSearchResult(List<RentalDTO> rentals, long totalElements, int totalPages, int pageNumber, int pageSize) {
        this.rentals = rentals;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
