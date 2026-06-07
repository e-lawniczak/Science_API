package oel.development.ScienceAPI.ICD.symptoms.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeywordDto {
    @NotEmpty
    private String keyword;
}
