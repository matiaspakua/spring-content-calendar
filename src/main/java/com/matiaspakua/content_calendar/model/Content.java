package com.matiaspakua.content_calendar.model;

import java.time.LocalDateTime;

public record Content(
        Integer id,
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime creationDate,
        LocalDateTime updateDate,
        String url
) {
}
