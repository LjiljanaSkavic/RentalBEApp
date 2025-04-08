package rentalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rentalapp.dto.MalfunctionDTO;
import rentalapp.dto.MalfunctionRequest;
import rentalapp.service.MalfunctionService;

@RestController
@RequestMapping("/malfunction")
public class MalfunctionController {
    @Autowired
    private MalfunctionService malfunctionService;

    @PostMapping()
    public ResponseEntity<MalfunctionDTO> create(@RequestBody MalfunctionRequest dto) {
        return new ResponseEntity<>(malfunctionService.create(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(malfunctionService.deleteById(id));
    }
}
