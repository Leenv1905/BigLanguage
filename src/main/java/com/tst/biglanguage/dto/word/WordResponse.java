package com.tst.biglanguage.dto.word;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WordResponse {

    private Long id;
    private String value;
    private String meaning;
    private String pronunciation;
    private String example;

    private Long languageId;
    private String languageCode;
    private String languageName;
}
