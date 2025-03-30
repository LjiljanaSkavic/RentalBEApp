package rentalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerRequest;
import rentalapp.dto.SearchResult;
import rentalapp.service.ManufacturerService;

import java.util.Map;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public SearchResult<ManufacturerDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return manufacturerService.getAllPageable(page, size);
    }

    @PostMapping
    public ResponseEntity<ManufacturerDTO> create(@RequestBody ManufacturerRequest manufacturerRequest) {
        ManufacturerDTO manufacturerDTO = manufacturerService.create(manufacturerRequest);

        if (manufacturerDTO != null) {
            return new ResponseEntity<>(manufacturerDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> update(@PathVariable Integer id,
                                                  @RequestBody ManufacturerRequest manufacturerRequest) {
        ManufacturerDTO manufacturerDTO = manufacturerService.update(id, manufacturerRequest);

        if (manufacturerDTO != null) {
            return new ResponseEntity<>(manufacturerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        boolean isDeleted = manufacturerService.delete(id);

        if (isDeleted) {
            return new ResponseEntity<>(Map.of("message", "Manufacturer deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("message", "Failed to delete manufacturer"), HttpStatus.NOT_FOUND);
        }
    }

}