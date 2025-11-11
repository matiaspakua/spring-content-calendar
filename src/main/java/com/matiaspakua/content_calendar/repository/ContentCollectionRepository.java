package com.matiaspakua.content_calendar.repository;

import com.matiaspakua.content_calendar.model.Content;
import com.matiaspakua.content_calendar.model.Status;
import com.matiaspakua.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    public List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(List<Content> contentList) {
        this.contentList = contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> id.equals(id)).findFirst();
    }

    public Optional<List<Content>> findAll() {
        return Optional.ofNullable(contentList);
    }

    @PostConstruct
    public void init() {
        Content content = new Content(
                1,
                "first test",
                "dummy description",
                Status.IDEA,
                Type.POST,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "none"
        );
        contentList.add(content);
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }
}
