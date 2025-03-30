package rentalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rentalapp.dto.RentalFile;
import rentalapp.entity.FileEntity;
import rentalapp.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private FileRepository fileRepository;


    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getById(@PathVariable Integer id) {
        try {
            Optional<FileEntity> optionalFile = fileRepository.findByIdAndIsDeletedFalse(id);
            if (optionalFile.isPresent()) {
                FileEntity file = optionalFile.get();
                Path filePath = Paths.get(file.getPath());
                Resource resource = new UrlResource(filePath.toUri());

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.parseMediaType(file.getType()));
                headers.setContentDispositionFormData("attachment", file.getName());
                headers.setContentLength(resource.contentLength());

                // Add cache control headers
                headers.setCacheControl(CacheControl.maxAge(30, TimeUnit.DAYS).cachePublic());
                return ResponseEntity.ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<RentalFile> upload(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String filePath = uploadPath + fileName;

            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            FileEntity uploadedFile = new FileEntity();
            uploadedFile.setName(fileName);
            uploadedFile.setType(file.getContentType());
            uploadedFile.setPath(filePath);
            uploadedFile.setDeleted(false);

            FileEntity savedFile = fileRepository.save(uploadedFile);

            RentalFile fileDto = new RentalFile();
            fileDto.setId(savedFile.getId());
            fileDto.setName(savedFile.getName());
            fileDto.setPath(savedFile.getPath());
            fileDto.setType(savedFile.getType());

            return ResponseEntity.ok(fileDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
