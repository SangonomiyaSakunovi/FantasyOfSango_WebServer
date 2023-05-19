package com.fantasy.sangoUser.service;

import com.fantasy.sangoUser.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> getArticleByType(String type);
    ArticleDto getArticleById(Integer id);
    List<ArticleDto> getNewestArticle(Integer num);
}
