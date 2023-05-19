package com.fantasy.sangoUser.mapper;

import com.fantasy.sangoUser.entity.Article;

public interface ArticleMapper {
    Article selectArticleById(int id);
    Article selectArticleByType(int type);
    int insertArticle(String title, String content, String author, String date, int type);
}
