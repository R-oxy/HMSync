package com.HMSync.authentication.controller;

import com.HMSync.authentication.controller.assembler.IdentificationDocumentAssembler;
import com.HMSync.authentication.controller.dto.IdentificationDocumentDto;
import com.HMSync.authentication.service.IdentificationDocumentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/identification-documents")
@Tag(name = "identification-documents")
public class IdentificationDocumentController {
    private final IdentificationDocumentService identificationDocumentService;
    private final IdentificationDocumentAssembler identificationDocumentAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IdentificationDocumentDto> findAll() {
        return identificationDocumentAssembler.toIdentificationDocumentDto(identificationDocumentService.findAll());
    }
}
