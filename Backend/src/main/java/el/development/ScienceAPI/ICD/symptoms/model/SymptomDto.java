package el.development.ScienceAPI.ICD.symptoms.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SymptomDto {
    @NotEmpty
    private String symptom;

    private List<SeverityLevelCreateDto> severityLevel;

}
