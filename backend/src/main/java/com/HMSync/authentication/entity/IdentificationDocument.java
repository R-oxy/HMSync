package com.HMSync.authentication.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "identification_documents")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class IdentificationDocument {
    @Id
    @GeneratedValue
    private UUID identificationDocumentId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @CreatedBy
    @Column(name = "created_user")
    private String createdUser;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @LastModifiedBy
    @Column(name = "updated_user")
    private String updatedUser;

    @JsonProperty("name")
    private String name;
}
