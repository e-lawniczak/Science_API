package oel.development.ScienceAPI.ICD.disorders;

import oel.development.ScienceAPI.ICD.disorders.model.Disorder;
import oel.development.ScienceAPI.ICD.disorders.model.DisorderCreateDto;
import oel.development.ScienceAPI.ICD.symptoms.SymptomService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oel.core.apiResponse.ApiException;
import oel.core.apiResponse.ApiStatusCode;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisorderService {

    private final DisorderRepository disorderRepository;
    private final SymptomService symptomService;


    public Disorder create(DisorderCreateDto dto) {
        try{
            return saveRecursive(dto, null);
        } catch (Exception e) {
            log.error("Disorder creation error", e);
            throw new ApiException(ApiStatusCode.ERROR, e.getMessage());
        }
    }

    @Transactional
    protected Disorder saveRecursive(
            DisorderCreateDto dto,
            Disorder parent) {

        Disorder disorder = disorderRepository
                .findByCode(dto.getCode())
                .orElseGet(Disorder::new);

        disorder.setCode(dto.getCode());
        disorder.setName(dto.getName());
        disorder.setDescription(dto.getDescription());
        disorder.setParent(parent);

        disorder = disorderRepository.save(disorder);
        symptomService.saveFromDisorder(dto);

        if (dto.getChildren() != null) {
            for (var child : dto.getChildren()) {
                saveRecursive(child, disorder);
            }
        }

        return disorder;
    }
}
