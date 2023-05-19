package com.fantasy.sangoUser.service.impl;

import com.fantasy.sangoUser.constant.ArticleConstant;
import com.fantasy.sangoUser.dto.ArticleDto;
import com.fantasy.sangoUser.entity.Article;
import com.fantasy.sangoUser.mapper.ArticleMapper;
import com.fantasy.sangoUser.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Override
    public List<ArticleDto> getArticleByType(String type) {
        List<Article> articles = articleMapper.selectArticleByType(ArticleConstant.TYPE_MAP.get(type));
        List<ArticleDto> result = new ArrayList<>();
        for(Article article:articles){
            result.add(new ArticleDto(article));
        }
        return result;
    }

    @Override
    public ArticleDto getArticleById(Integer id) {
        Article article = articleMapper.selectArticleById(id);
        return new ArticleDto(article);
    }

    @Override
    public List<ArticleDto> getNewestArticle(Integer num) {
        List<Article> articles = articleMapper.selectNewestArticle(num);
        List<ArticleDto> result = new ArrayList<>();
        for(Article article:articles){
            result.add(new ArticleDto(article));
        }
        return result;
    }
}
