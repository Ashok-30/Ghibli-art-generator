package in.ashok.artgenerator.service;

import in.ashok.artgenerator.DTO.TextToImageRequest;
import in.ashok.artgenerator.client.StabilityAIClient;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

@Service
public class GhibliArtService {

    private final StabilityAIClient stabilityAIClient;
    private final String apiKey;

    public GhibliArtService(StabilityAIClient stabilityAIClient,@Value("${stability.api.key}") String apiKey) {
        this.stabilityAIClient=stabilityAIClient;
        this.apiKey = apiKey;
    }











    public byte[] createGhibliArtFromText(String prompt, String style) {
        String finalPrompt = prompt + ", in the beautiful, detailed anime style of Studio Ghibli.";
        String engineId = "stable-diffusion-xl-1024-v1-0";
        String stylePreset = style.equals("general") ? "anime" : style.replace("_", "-");

        List<TextToImageRequest.TextPrompt> prompts = List.of(new TextToImageRequest.TextPrompt(finalPrompt));

        TextToImageRequest requestPayload = new TextToImageRequest(
                prompts,
                stylePreset,
                1024,
                1024,
                1,
                30,
                7.0f
        );

        return stabilityAIClient.generateImageFromText(
                "Bearer " + apiKey,
                engineId,
                requestPayload
        );
    }


}
