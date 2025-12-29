package com.tst.biglanguage.dto.word;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordCreateRequest {

    @NotBlank
    private String value;

    private String meaning;
    private String pronunciation;
    private String example;

    @NotNull
    private Long languageId;
}
