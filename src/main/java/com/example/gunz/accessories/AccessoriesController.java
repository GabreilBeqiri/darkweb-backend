package com.example.gunz.accessories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/acc")
public class AccessoriesController {

    @Autowired
    private AccessoriesService accessoriesService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";
    @PostMapping("/add")
    public ResponseEntity<Accessories> saveaccessories(@RequestBody RegisterAccessoriesDto registerAccessoriesDto ){
        return accessoriesService.saveAccessories(registerAccessoriesDto);
    }

    @PutMapping("/upload/{id}")
    public void uploadImage(
            @PathVariable String id,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, multipartFile.getOriginalFilename());
        fileNames.append(multipartFile.getOriginalFilename());
        Files.write(fileNameAndPath, multipartFile.getBytes());

        this.accessoriesService.setImageToSingleAccess(multipartFile.getOriginalFilename(), id);
    }
    @GetMapping
    public ResponseEntity<List<Accessories>> getAllAccess() {
        return accessoriesService.getAllAccessories();
    }

    @GetMapping("single/{id}")
    public ResponseEntity<Accessories> getSingleAccessory(@PathVariable(name="id") Long id) {
        return accessoriesService.getSingleAccessories(id);
    }

}
