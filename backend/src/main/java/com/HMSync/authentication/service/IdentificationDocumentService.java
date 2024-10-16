package com.HMSync.authentication.service;

import com.HMSync.authentication.entity.IdentificationDocument;

import java.util.List;

public interface IdentificationDocumentService {
    List<IdentificationDocument> findAll();
}
