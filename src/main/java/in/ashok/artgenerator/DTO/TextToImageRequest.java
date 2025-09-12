package in.ashok.artgenerator.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextToImageRequest {
    private List<TextPrompt> text_prompts;
    private String style_preset;
    private int width;
    private int height;
    private int samples;
    private int steps;
    private float cfg_scale;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TextPrompt {
        private String text;
    }
}
