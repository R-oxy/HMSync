package com.HMSync.authentication.repository;

import com.HMSync.authentication.entity.IdentificationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, UUID> {
    Optional<IdentificationDocument> findByName(String name);
}
