package rentalapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchResult<T> {
    private List<T> data;
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public SearchResult(List<T> data, long totalElements, int totalPages, int pageNumber, int pageSize) {
        this.data = data;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
