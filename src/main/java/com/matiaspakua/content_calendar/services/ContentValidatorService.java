package com.matiaspakua.content_calendar.services;

import org.springframework.stereotype.Service;

@Service
public class ContentValidatorService {
    private Integer contentIdentifierCounter = 0;

    /**
     * Get the latest content identifier.
     * TODO: This interface shall be replaced with a get of the last ID from the database instead of this.
     * @return
     */
    public Integer getContentIdentifierCounter() {
        this.contentIdentifierCounter++;

        return contentIdentifierCounter;
    }
}
