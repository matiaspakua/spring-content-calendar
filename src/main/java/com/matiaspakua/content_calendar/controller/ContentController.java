package com.matiaspakua.content_calendar.controller;

import com.matiaspakua.content_calendar.model.Content;
import com.matiaspakua.content_calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }


    @GetMapping
    public List<Content> findAll() {
        return this.contentCollectionRepository.findAll().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No content found"));
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable Integer id) {
        return Optional.ofNullable(contentCollectionRepository.findById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }
}
