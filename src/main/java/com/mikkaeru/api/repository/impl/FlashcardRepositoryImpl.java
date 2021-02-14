package com.mikkaeru.api.repository.impl;

import com.mikkaeru.api.domain.model.flashcard.Flashcard;
import com.mikkaeru.api.repository.FlashcardRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.Optional;
import java.util.UUID;

public class FlashcardRepositoryImpl implements FlashcardRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlashcardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Flashcard flashcard) {

        var sql = "INSERT INTO flashcard(" + BOX_FIELD + ", " + BACK_FIELD + ", " + FRONT_FIELD + ", " + REVIEW_FIELD +
                ", " + EXTERNAL_ID_FIELD + ", " + CREATED_AT_FIELD + ", " + UPDATED_AT_FIELD + ", " + LAST_REVISION_FIELD +
                ") " + "VALUES (" + BOX_FIELD + ", " + BACK_FIELD + ", " + FRONT_FIELD + ", " + REVIEW_FIELD + ", " + EXTERNAL_ID_FIELD +
                ", " + CREATED_AT_FIELD + ", " + UPDATED_AT_FIELD + ", " + LAST_REVISION_FIELD + ")";

        try {

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(BOX_FIELD, flashcard.getBox())
                    .addValue(BACK_FIELD, flashcard.getBack())
                    .addValue(FRONT_FIELD, flashcard.getFront())
                    .addValue(REVIEW_FIELD, flashcard.getReview())
                    .addValue(EXTERNAL_ID_FIELD, flashcard.getExternalId())
                    .addValue(CREATED_AT_FIELD, flashcard.getCreatedAt())
                    .addValue(UPDATED_AT_FIELD, flashcard.getUpdatedAt())
                    .addValue(LAST_REVISION_FIELD, flashcard.getLastRevision());

            jdbcTemplate.update(sql, parameters);

        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Flashcard flashcard) {

    }

    @Override
    public Optional<Flashcard> findByExternalId(UUID externalId) {
        return Optional.empty();
    }
}
