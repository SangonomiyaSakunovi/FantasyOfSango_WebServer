package com.fantasy.sangoUser.mapper;

import com.fantasy.sangoUser.entity.Article;

import java.util.List;

public interface ArticleMapper {
    Article selectArticleById(int id);
    List<Article> selectArticleByType(int type);
    List<Article> selectNewestArticle(int num);
    int insertArticle(String title, String content, String author, String date, int type);
}
