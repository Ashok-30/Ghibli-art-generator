package in.ashok.artgenerator.controller;

import in.ashok.artgenerator.DTO.TextGenerationRequestDTO;
import in.ashok.artgenerator.service.GhibliArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")

@CrossOrigin(origins = "https://your-frontend-domain.onrender.com")
@RequiredArgsConstructor
public class GenerationController {

    private final GhibliArtService ghibliArtService;


    @PostMapping(value="/generate-from-text",produces=MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateGhibliArtFromText(@RequestBody TextGenerationRequestDTO requestDTO){
        try{
           byte[] imageBytes= ghibliArtService.createGhibliArtFromText(requestDTO.getPrompt(),requestDTO.getStyle());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
        }
        catch ( Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();

        }
    }

}
