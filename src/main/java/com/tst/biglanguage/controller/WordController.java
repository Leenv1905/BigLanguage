package com.tst.biglanguage.controller;

import com.tst.biglanguage.dto.word.WordCreateRequest;
import com.tst.biglanguage.dto.word.WordResponse;
import com.tst.biglanguage.service.WordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@PreAuthorize("hasRole('USER')")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    // Thêm từ mới
    @PostMapping
    public ResponseEntity<WordResponse> create(
            @Valid @RequestBody WordCreateRequest request
    ) {
        return ResponseEntity.ok(wordService.createWord(request));
    }

    // Lấy toàn bộ từ của tôi
    @GetMapping
    public ResponseEntity<List<WordResponse>> getMyWords() {
        return ResponseEntity.ok(wordService.getMyWords());
    }

    // Search từ của tôi
    @GetMapping("/search")
    public ResponseEntity<List<WordResponse>> search(
            @RequestParam String q
    ) {
        return ResponseEntity.ok(wordService.searchMyWords(q));
    }
}
