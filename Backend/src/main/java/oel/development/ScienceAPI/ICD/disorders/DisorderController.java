package oel.development.ScienceAPI.ICD.disorders;

import oel.development.ScienceAPI.ICD.disorders.model.DisorderCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("icd/disorder")
@RequiredArgsConstructor
public class DisorderController {

    private final DisorderService disorderService;

    @PostMapping
    public Long create(
            @RequestBody DisorderCreateDto dto) {

        return disorderService.create(dto).getId();
    }
}
