package com.tst.biglanguage.service;

import com.tst.biglanguage.dto.language.LanguageCreateRequest;
import com.tst.biglanguage.dto.language.LanguageResponse;

import java.util.List;

public interface LanguageService {

    LanguageResponse create(LanguageCreateRequest request);

    List<LanguageResponse> getAll();
}
