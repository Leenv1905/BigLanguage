package com.tst.biglanguage.dto.language;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LanguageCreateRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String name;
}
