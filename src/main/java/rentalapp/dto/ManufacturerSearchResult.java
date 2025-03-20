package rentalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ManufacturerSearchResult {
    private List<ManufacturerDTO> manufacturers;
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public ManufacturerSearchResult(List<ManufacturerDTO> manufacturers, long totalElements, int totalPages, int pageNumber, int pageSize) {
        this.manufacturers = manufacturers;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
