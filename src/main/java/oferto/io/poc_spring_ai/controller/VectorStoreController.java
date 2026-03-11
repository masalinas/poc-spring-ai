package oferto.io.poc_spring_ai.controller;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oferto.io.poc_spring_ai.service.RedisVectorStoreService;

@RestController
@RequestMapping("/store")
public class VectorStoreController {
	private final RedisVectorStoreService vectorStoreService;

    public VectorStoreController(RedisVectorStoreService vectorStoreService) {
        this.vectorStoreService = vectorStoreService;
    }

    @GetMapping("/add-document")
    public void addDocument(@RequestParam String document) {
        vectorStoreService.addDocument(document);
    }
    
    @GetMapping("/search-documents")
    public List<Document> searchDocuments(@RequestParam String query) {
        return vectorStoreService.searchDocuments(query);
    }
}
