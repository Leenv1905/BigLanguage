package com.tst.biglanguage.mapper;

import com.tst.biglanguage.dto.language.LanguageResponse;
import com.tst.biglanguage.entity.Language;

public class LanguageMapper {

    private LanguageMapper() {}

    public static LanguageResponse toResponse(Language language) {
        return LanguageResponse.builder()
                .id(language.getId())
                .code(language.getCode())
                .name(language.getName())
                .build();
    }
}
