package com.tst.biglanguage.controller;

import com.tst.biglanguage.dto.language.LanguageCreateRequest;
import com.tst.biglanguage.dto.language.LanguageResponse;
import com.tst.biglanguage.service.LanguageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    // ADMIN tạo language
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LanguageResponse> create(
            @Valid @RequestBody LanguageCreateRequest request
    ) {
        return ResponseEntity.ok(languageService.create(request));
    }

    // USER + ADMIN đều xem được
    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAll() {
        return ResponseEntity.ok(languageService.getAll());
    }
}
