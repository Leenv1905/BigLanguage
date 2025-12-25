package com.tst.biglanguage.repository;

import com.tst.biglanguage.entity.Word;
import com.tst.biglanguage.entity.User;
import com.tst.biglanguage.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    // Lấy tất cả từ của 1 user
    List<Word> findByUser(User user);

    // Lấy từ theo user + language
    List<Word> findByUserAndLanguage(User user, Language language);

    // Tìm kiếm theo keyword
    List<Word> findByUserAndValueContainingIgnoreCase(User user, String keyword);

    // Check trùng từ (tránh nhập trùng)
    boolean existsByUserAndValueIgnoreCase(User user, String value);
}
