package oel.development.ScienceAPI.ICD.symptoms;

import oel.development.ScienceAPI.ICD.disorders.model.DisorderCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomService {
    private final SymptomRepository symptomRepository;
    private final SeverityLevelRepository severityLevelRepository;
    private final KeywordRepository keywordRepository;

    public void saveFromDisorder(DisorderCreateDto dto) {
    }
}
