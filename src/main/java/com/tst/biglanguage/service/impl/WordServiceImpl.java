package com.tst.biglanguage.service.impl;

import com.tst.biglanguage.dto.word.WordCreateRequest;
import com.tst.biglanguage.dto.word.WordResponse;
import com.tst.biglanguage.entity.Language;
import com.tst.biglanguage.entity.User;
import com.tst.biglanguage.entity.Word;
import com.tst.biglanguage.mapper.WordMapper;
import com.tst.biglanguage.repository.LanguageRepository;
import com.tst.biglanguage.repository.UserRepository;
import com.tst.biglanguage.repository.WordRepository;
import com.tst.biglanguage.service.WordService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//Điểm mấu chốt của logic trong đây
//❌ Không nhận userId từ client
//✅ Lấy user từ SecurityContext
//✅ Security là nguồn chuẩn

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;

    public WordServiceImpl(
            WordRepository wordRepository,
            UserRepository userRepository,
            LanguageRepository languageRepository
    ) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public WordResponse createWord(WordCreateRequest request) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (wordRepository.existsByUserAndValueIgnoreCase(user, request.getValue())) {
            throw new RuntimeException("Word already exists for this user");
        }

        Language language = languageRepository.findById(request.getLanguageId())
                .orElseThrow(() -> new RuntimeException("Language not found"));

        Word word = Word.builder()
                .value(request.getValue())
                .meaning(request.getMeaning())
                .pronunciation(request.getPronunciation())
                .example(request.getExample())
                .language(language)
                .user(user)
                .build();

        return WordMapper.toResponse(wordRepository.save(word));
    }

    @Override
    public List<WordResponse> getMyWords() {

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return wordRepository.findByUser(user)
                .stream()
                .map(WordMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<WordResponse> searchMyWords(String keyword) {

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return wordRepository
                .findByUserAndValueContainingIgnoreCase(user, keyword)
                .stream()
                .map(WordMapper::toResponse)
                .collect(Collectors.toList());
    }
}
