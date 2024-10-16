package com.HMSync.authentication.controller.assembler;

import com.HMSync.authentication.controller.dto.IdentificationDocumentDto;
import com.HMSync.authentication.entity.IdentificationDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IdentificationDocumentAssembler {

    public IdentificationDocumentDto toIdentificationDocumentDto(IdentificationDocument from) {
        return new IdentificationDocumentDto(from.getName());
    }

    public List<IdentificationDocumentDto> toIdentificationDocumentDto(List<IdentificationDocument> from) {
        return from.stream()
                .map(this::toIdentificationDocumentDto)
                .collect(Collectors.toList());
    }
}
