package com.HMSync.authentication.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class IdentificationDocumentDto {
    public static final IdentificationDocumentDto IDENTIFICATION_CARD = new IdentificationDocumentDto("Identification Card");
    public static final IdentificationDocumentDto PASSPORT = new IdentificationDocumentDto("Passport");

    private final String value;

    @JsonCreator
    public IdentificationDocumentDto(@NonNull String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
