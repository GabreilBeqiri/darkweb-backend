package com.example.gunz.armet;

import com.example.gunz.armet.dto.RegisterGunsDto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gun")
public class ArmetController {
    @Autowired
    private ArmetService armetService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";

    @PostMapping("/add")
    public ResponseEntity<Armet> savegunz(@RequestBody RegisterGunsDto registerGunsDto ){
        return armetService.saveArmet(registerGunsDto);
    }

    @PutMapping("/upload/{id}")
    public void uploadImage(
            @PathVariable String id,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, multipartFile.getOriginalFilename());
        fileNames.append(multipartFile.getOriginalFilename());
        Files.write(fileNameAndPath, multipartFile.getBytes());

        this.armetService.setImageToSingleArme(multipartFile.getOriginalFilename(),id);

    }
    @GetMapping
    public ResponseEntity<List<Armet>> getAllArmet() {
        return armetService.getAllArmet(null);
    }

    @GetMapping("{type}")
    public ResponseEntity<List<Armet>> getHunting(@PathVariable String type) {
        return armetService.getAllArmet(type);
    }


}

