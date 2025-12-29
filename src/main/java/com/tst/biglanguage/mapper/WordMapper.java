package com.tst.biglanguage.mapper;

import com.tst.biglanguage.dto.word.WordResponse;
import com.tst.biglanguage.entity.Word;

public class WordMapper {

    private WordMapper() {}

    public static WordResponse toResponse(Word word) {
        return WordResponse.builder()
                .id(word.getId())
                .value(word.getValue())
                .meaning(word.getMeaning())
                .pronunciation(word.getPronunciation())
                .example(word.getExample())
                .languageId(word.getLanguage().getId())
                .languageCode(word.getLanguage().getCode())
                .languageName(word.getLanguage().getName())
                .build();
    }
}
