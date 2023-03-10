package com.controllers;

import com.dtos.ArticleDto;
import com.services.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Un contrôleur Spring qui gère les requêtes HTTP relatives aux articles
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    // Une méthode qui renvoie la liste de tous les articles existants dans le système
    @GetMapping
    public List<ArticleDto> getArticles() {
        return articleService.getAllArticles();
    }

    /**
     * Méthode pour obtenir l'article en fonction de l'ID
     */
    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    /**
     * Créer un nouvel article dans le système
     */
    @PostMapping
    public ArticleDto saveArticle(final @RequestBody ArticleDto articleDto){
        return articleService.saveArticle(articleDto);
    }

    /**
     * Supprimer un article par son identifiant
     */
    @DeleteMapping("/{id}")
    public Boolean deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }
}
