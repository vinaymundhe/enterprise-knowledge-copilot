package com.ekc.enterprise_knowledge_copilot.document.api.dto;

import java.time.Instant;

public class DocumentResponse {
    private Long id;
    private String title;
    private String content;
    private String source;
    private Instant createdAt;

    public DocumentResponse(Long id, String title, String content, String source, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.source = source;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getSource() { return source; }
    public Instant getCreatedAt() { return createdAt; }
}
