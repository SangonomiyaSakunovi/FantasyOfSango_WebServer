package com.fantasy.sangoUser.dto;

import com.fantasy.sangoUser.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private int type;

    public ArticleDto(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor();
        //截取date的年月日
        this.date = article.getDate().substring(0,10);
        this.type = article.getType();
    }
}
