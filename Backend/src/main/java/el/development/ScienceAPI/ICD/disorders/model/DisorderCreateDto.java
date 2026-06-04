package el.development.ScienceAPI.ICD.disorders.model;

import el.development.ScienceAPI.ICD.symptoms.model.KeywordCreateDto;
import el.development.ScienceAPI.ICD.symptoms.model.SymptomCreateDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DisorderCreateDto {

    @NotEmpty
    private String code;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String whoLink;

    private List<DisorderCreateDto> children;
    private List<SymptomCreateDto> symptoms;
    private List<KeywordCreateDto> keywords;


}