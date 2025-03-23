package rentalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.VehicleSearchResult;
import rentalapp.service.VehicleService;

import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public VehicleSearchResult getAllVehicles(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "") String category) {
        return vehicleService.getAllVehiclesPaginated(page, size, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteManufacturer(@PathVariable Integer id) {
        boolean isDeleted = vehicleService.deleteVehicle(id);

        if (isDeleted) {
            return new ResponseEntity<>(Map.of("message", "Vehicle deleted successfully"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("message", "Failed to delete vehicle"), HttpStatus.NOT_FOUND);
        }
    }
}