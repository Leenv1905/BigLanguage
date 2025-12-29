package com.tst.biglanguage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
    public class UserProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fullName;
        private String phone;
        private String avatar;
        private LocalDate birthday;

        @OneToOne
        @JoinColumn(name = "user_id", unique = true)
        private User user;
    }

