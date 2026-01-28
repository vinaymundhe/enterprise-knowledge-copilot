package com.ekc.enterprise_knowledge_copilot.document.api;

import com.ekc.enterprise_knowledge_copilot.document.entity.Document;
import com.ekc.enterprise_knowledge_copilot.document.repo.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRepository repo;

    @PostMapping
    public Document create(@RequestBody Document doc) {
        doc.setId(null); // ignore client id
        return repo.save(doc);
    }

    @GetMapping
    public List<Document> all() {
        return repo.findAll();
    }
}
