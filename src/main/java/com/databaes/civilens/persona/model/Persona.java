package com.databaes.civilens.persona.model;

import com.databaes.civilens.common.enums.core.Language;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;

@Data
public class Persona {

    private String id;

    @NotNull(message = "Language preference is required")
    private Language language;

    @NotNull(message = "Demographics information is required")
    @Valid
    private Demographics demographics;

    @NotNull(message = "Economic information is required")
    @Valid
    private Economic economic;

    @NotNull(message = "Geographic information is required")
    @Valid
    private Geographic geographic;

    @NotNull(message = "Occupation information is required")
    @Valid
    private Occupation occupation;

    private Instant createdAt;
}
