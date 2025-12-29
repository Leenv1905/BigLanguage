package com.tst.biglanguage.dto.language;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LanguageResponse {

    private Long id;
    private String code;
    private String name;
}
