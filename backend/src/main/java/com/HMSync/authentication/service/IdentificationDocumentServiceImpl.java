package com.HMSync.authentication.service;

import com.HMSync.authentication.entity.IdentificationDocument;
import com.HMSync.authentication.repository.IdentificationDocumentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IdentificationDocumentServiceImpl implements IdentificationDocumentService {
    private final IdentificationDocumentRepository identificationDocumentRepository;

    @Override
    public List<IdentificationDocument> findAll() {
        return identificationDocumentRepository.findAll();
    }
}
