package com.fantasy.sangoUser.dto;

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
}
