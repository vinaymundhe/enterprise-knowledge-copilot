package com.ekc.enterprise_knowledge_copilot.document.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DocumentCreateRequest {

    @NotBlank(message = "title is required")
    @Size(max = 200, message = "title must be <= 200 chars")
    private String title;

    @NotBlank(message = "content is required")
    @Size(max = 10000, message = "content must be <= 10000 chars")
    private String content;

    @Size(max = 100, message = "source must be <= 100 chars")
    private String source;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
}
