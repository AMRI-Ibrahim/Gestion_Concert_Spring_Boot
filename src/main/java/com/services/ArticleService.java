package com.services;

import com.dtos.ArticleDto;
import com.dtos.ConcertDto;

import java.util.List;

public interface ArticleService {
    ArticleDto saveArticle(ArticleDto articleDto);


    ArticleDto getArticleById(Long articleId);


    boolean deleteArticle(Long articleId);


    List<ArticleDto> getAllArticles();
}
