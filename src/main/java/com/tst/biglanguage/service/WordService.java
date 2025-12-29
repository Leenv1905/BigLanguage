package com.tst.biglanguage.service;

import com.tst.biglanguage.dto.word.WordCreateRequest;
import com.tst.biglanguage.dto.word.WordResponse;

import java.util.List;

public interface WordService {

    WordResponse createWord(WordCreateRequest request);

    List<WordResponse> getMyWords();

    List<WordResponse> searchMyWords(String keyword);
}
