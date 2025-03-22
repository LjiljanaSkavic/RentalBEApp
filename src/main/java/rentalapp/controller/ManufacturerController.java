package rentalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.ManufacturerDTO;
import rentalapp.dto.ManufacturerRequest;
import rentalapp.dto.ManufacturerSearchResult;
import rentalapp.service.ManufacturerService;

import java.util.Map;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public ManufacturerSearchResult getAllVehicles(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        return manufacturerService.getAllManufacturersPaginated(page, size);
    }

    @PostMapping
    public ResponseEntity<ManufacturerDTO> createManufacturer(@RequestBody ManufacturerRequest manufacturerRequest) {
        ManufacturerDTO manufacturerDTO = manufacturerService.createManufacturer(manufacturerRequest);

        if (manufacturerDTO != null) {
            return new ResponseEntity<>(manufacturerDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerDTO> updateManufacturer(@PathVariable Integer id,
                                                              @RequestBody ManufacturerRequest manufacturerRequest) {
        ManufacturerDTO manufacturerDTO = manufacturerService.updateManufacturer(id, manufacturerRequest);

        if (manufacturerDTO != null) {
            return new ResponseEntity<>(manufacturerDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteManufacturer(@PathVariable Integer id) {
        boolean isDeleted = manufacturerService.deleteManufacturer(id);

        if (isDeleted) {
            return new ResponseEntity<>(Map.of("message", "Manufacturer deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("message", "Failed to delete manufacturer"), HttpStatus.NOT_FOUND);
        }
    }

}