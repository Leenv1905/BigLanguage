package com.tst.biglanguage.service.impl;

import com.tst.biglanguage.dto.language.LanguageCreateRequest;
import com.tst.biglanguage.dto.language.LanguageResponse;
import com.tst.biglanguage.entity.Language;
import com.tst.biglanguage.mapper.LanguageMapper;
import com.tst.biglanguage.repository.LanguageRepository;
import com.tst.biglanguage.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public LanguageResponse create(LanguageCreateRequest request) {

        if (languageRepository.existsByCode(request.getCode())) {
            throw new RuntimeException("Language code already exists");
        }

        Language language = Language.builder()
                .code(request.getCode().toLowerCase())
                .name(request.getName())
                .build();

        return LanguageMapper.toResponse(languageRepository.save(language));
    }

    @Override
    public List<LanguageResponse> getAll() {
        return languageRepository.findAll()
                .stream()
                .map(LanguageMapper::toResponse)
                .collect(Collectors.toList());
    }
}
