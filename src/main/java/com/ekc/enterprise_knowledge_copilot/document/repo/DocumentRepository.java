package com.ekc.enterprise_knowledge_copilot.document.repo;

import com.ekc.enterprise_knowledge_copilot.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
