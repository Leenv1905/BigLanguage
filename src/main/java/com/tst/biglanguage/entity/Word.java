package com.tst.biglanguage.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "words")
@Table(
        name = "words",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "value"})
        }
)
// uniqueConstraints -> 1 User không được lưu trùng , nhưng user khác thì được
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nội dung từ vựng
    @Column(nullable = false, length = 255)
    private String value; // apple, 苹果

    // Nghĩa người dùng tự nhập
    @Column(length = 500)
    private String meaning;

    @Column(length = 255)
    private String pronunciation;

    @Column(length = 500)
    private String example;

    // Từ này thuộc ngôn ngữ nào
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    // Từ này của user nào
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

