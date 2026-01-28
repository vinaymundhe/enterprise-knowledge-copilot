package com.ekc.enterprise_knowledge_copilot.document.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // e.g. "HR Policy - Leave"
    @Column(nullable = false)
    private String title;

    // raw text for now (later we store file + extracted text)
    @Column(nullable = false, columnDefinition = "text")
    private String content;

    // where it came from: "manual", "upload", "confluence", etc.
    @Column(nullable = false)
    private String source;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }
}

