package com.iitu.reader_service.client;

import com.iitu.reader_service.model.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "article-service")
public interface ArticleClient {

    @GetMapping("/api/articles")
    List<Article> getAllArticles();

    @GetMapping("/api/articles/{id}")
    Article getArticleById(@PathVariable("id") Long id);
}
