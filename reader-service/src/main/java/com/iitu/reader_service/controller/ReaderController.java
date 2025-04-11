package com.iitu.reader_service.controller;

import com.iitu.reader_service.client.ArticleClient;
import com.iitu.reader_service.model.Article;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    private final ArticleClient articleClient;

    public ReaderController(ArticleClient articleClient) {
        this.articleClient = articleClient;
    }

    // GET /api/reader/articles?title=...&page=...&size=...
    @GetMapping("/articles")
    public List<Article> getArticles(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<Article> allArticles = articleClient.getAllArticles();

        // Фильтрация по заголовку
        if (title != null && !title.isEmpty()) {
            allArticles = allArticles.stream()
                    .filter(article -> article.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());
        }

        // Сортировка по ID
        allArticles.sort(Comparator.comparingLong(Article::getId));

        // Пагинация
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, allArticles.size());

        if (fromIndex > allArticles.size()) {
            return List.of();
        }

        return allArticles.subList(fromIndex, toIndex);
    }

    // GET /api/reader/articles/{id}
    @GetMapping("/articles/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleClient.getArticleById(id);
    }
}
