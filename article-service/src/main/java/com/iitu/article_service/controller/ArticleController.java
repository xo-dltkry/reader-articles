package com.iitu.article_service.controller;

import com.iitu.article_service.model.Article;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final List<Article> articles = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(3);

    public ArticleController() {
        articles.add(new Article(1L, "<h2>🧩 What is Microservices?</h2>", "<p>Microservices is a modern software architecture...</p>"));
        articles.add(new Article(2L, "Spring Cloud Feign", "<p>Spring Cloud Feign simplifies communication...</p>"));
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articles;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articles.stream()
                .filter(article -> article.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found"));
    }

    @PostMapping
    public Article createArticle(@RequestBody Article newArticle) {
        newArticle.setId(idGenerator.getAndIncrement());
        articles.add(newArticle);
        return newArticle;
    }
}
