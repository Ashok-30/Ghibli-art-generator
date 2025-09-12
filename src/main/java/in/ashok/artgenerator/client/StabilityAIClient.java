package in.ashok.artgenerator.client;

import feign.Headers;
import in.ashok.artgenerator.DTO.TextToImageRequest;
import in.ashok.artgenerator.config.FeignConfig;
import org.springframework.core.io.Resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        name = "stabilityAiClient",
        url="${stability.api.base-url}",
        configuration= in.ashok.artgenerator.config.FeignConfig.class
)
public interface StabilityAIClient {
    @PostMapping(
            value="/v1/generation/{engine_id}/text-to-image",
            consumes= MediaType.APPLICATION_JSON_VALUE,
            headers = {"Accept=image/png"}
    )
    byte[]generateImageFromText(
            @RequestHeader("Authorization") String authorizationHeader,
            @PathVariable("engine_id") String engineId,
            @RequestBody TextToImageRequest requestBody
            );




}
