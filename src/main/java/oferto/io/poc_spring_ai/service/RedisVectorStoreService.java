package oferto.io.poc_spring_ai.service;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

@Service
public class RedisVectorStoreService {
    private final VectorStore vectorStore;

    public RedisVectorStoreService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
	
	final int TOP_K = 5;
	
    public void addDocument(String document) {
        this.vectorStore.add(List.of(new Document(document)));
    }
    
    public List<Document> searchDocuments(String query) {
    	return this.vectorStore.similaritySearch(
    			SearchRequest.builder().query(query).topK(TOP_K).build());
    }
}
