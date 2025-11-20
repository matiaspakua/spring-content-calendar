package com.matiaspakua.content_calendar.controller;

import com.matiaspakua.content_calendar.model.Content;
import com.matiaspakua.content_calendar.repository.ContentCollectionRepository;
import com.matiaspakua.content_calendar.services.ContentValidatorService;
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
    private final ContentValidatorService contentValidatorService;

    public ContentController(ContentCollectionRepository contentCollectionRepository,
            ContentValidatorService contentValidatorService) {
        this.contentCollectionRepository = contentCollectionRepository;
        this.contentValidatorService = contentValidatorService;

    }

    @GetMapping
    public List<Content> findAll() {
        return this.contentCollectionRepository.findAll()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No content found"));
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return contentCollectionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    public void create(Content content) {
        Content newContent = new Content(
                this.contentValidatorService.getContentIdentifierCounter(),
                content.title(),
                content.description(),
                content.status(),
                content.contentType(),
                content.creationDate(),
                content.updateDate(),
                content.url());
        this.contentCollectionRepository.save(content);
    }
}
