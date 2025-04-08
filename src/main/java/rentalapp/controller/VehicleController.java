package rentalapp.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.SearchResult;
import rentalapp.dto.VehicleDTO;
import rentalapp.dto.VehicleReqDTO;
import rentalapp.enums.VehicleCategory;
import rentalapp.service.VehicleService;

import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public SearchResult<? extends VehicleDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size,
                                                     @RequestParam @Nullable VehicleCategory category) {
        return vehicleService.getAllPageable(page, size, category);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> create(@RequestBody VehicleReqDTO dto) {
        return new ResponseEntity<>(
                vehicleService.create(dto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> update(@PathVariable Integer id, @RequestBody VehicleReqDTO dto) {
        return ResponseEntity.ok(vehicleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        boolean isDeleted = vehicleService.deleteVehicle(id);

        if (isDeleted) {
            return new ResponseEntity<>(Map.of("message", "Vehicle deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("message", "Failed to delete vehicle"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public VehicleDTO get(@PathVariable Integer id) {
        return vehicleService.getDetails(id);
    }
}