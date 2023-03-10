package com.services.impl;

import com.dtos.ArticleDto;
import com.entities.Article;
import com.repositories.ArticleRepository;
import com.services.ArticleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    // Le repository qui permet d'accéder aux données des articles
    private final ArticleRepository articleRepository;
    // Le constructeur qui injecte le repository
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto saveArticle(ArticleDto articleDto) {
        // Converts the dto to the article entity
        Article article = articleDtoToEntity(articleDto);
        // Save the article entity
        article = articleRepository.save(article);
        // Return the new dto
        return articleEntityToDto(article);
    }
    // Récupère l'entité article par son identifiant ou lance une exception si elle n'existe pas
    @Override
    public ArticleDto getArticleById(Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new EntityNotFoundException("Article not found"));
        return articleEntityToDto(article);
    }

    // Supprime l'entité article par son identifiant
    @Override
    public boolean deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
        return true;
    }
    //Retourner tous les  articles
    @Override
    public List<ArticleDto> getAllArticles() {
        List<ArticleDto> articleDtos = new ArrayList<>();
        List<Article> articles = articleRepository.findAll();
        articles.forEach(art -> {
            articleDtos.add(articleEntityToDto(art));
        });
        return articleDtos;
    }

    private ArticleDto articleEntityToDto(Article article){
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArt_id(article.getArt_id());
        articleDto.setArt_titre(article.getArt_titre());
        articleDto.setArt_description(article.getArt_description());
        articleDto.setArt_auteur(article.getArt_auteur());
        articleDto.setArt_date(article.getArt_date());
        return articleDto;
    }

    /**
     * change article entity to dog dto
     */
    private Article articleDtoToEntity(ArticleDto articleDto){
        Article article = new Article();
        article.setArt_id(articleDto.getArt_id());
        article.setArt_titre(articleDto.getArt_titre());
        article.setArt_description(articleDto.getArt_description());
        article.setArt_auteur(articleDto.getArt_auteur());
        article.setArt_date(articleDto.getArt_date());
        return article;
    }
}
