package com.ekc.enterprise_knowledge_copilot.document.api;

import com.ekc.enterprise_knowledge_copilot.document.api.dto.DocumentCreateRequest;
import com.ekc.enterprise_knowledge_copilot.document.api.dto.DocumentResponse;
import com.ekc.enterprise_knowledge_copilot.document.entity.Document;
import com.ekc.enterprise_knowledge_copilot.document.repo.DocumentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRepository repo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentResponse create(@Valid @RequestBody DocumentCreateRequest req) {
        Document doc = new Document();
        doc.setTitle(req.getTitle());
        doc.setContent(req.getContent());
        doc.setSource(req.getSource());

        return toResponse(repo.save(doc));
    }

    @GetMapping
    public List<DocumentResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public DocumentResponse getById(@PathVariable Long id) {
        Document doc = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        return toResponse(doc);
    }

    private DocumentResponse toResponse(Document doc) {
        return new DocumentResponse(
                doc.getId(),
                doc.getTitle(),
                doc.getContent(),
                doc.getSource(),
                doc.getCreatedAt()
        );
    }
}
