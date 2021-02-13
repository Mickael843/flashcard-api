package com.mikkaeru.api.repository.impl;

import com.mikkaeru.api.domain.model.flashcard.Flashcard;
import com.mikkaeru.api.repository.FlashcardRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public class FlashcardRepositoryImpl implements FlashcardRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlashcardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Flashcard create(Flashcard entity) {

        var sql = "";

        jdbcTemplate.update(sql);

        return null;
    }
}
