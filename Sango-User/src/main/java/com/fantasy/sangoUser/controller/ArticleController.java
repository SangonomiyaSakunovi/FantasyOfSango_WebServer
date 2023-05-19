package com.fantasy.sangoUser.controller;

import com.fantasy.sangoCommon.entity.CommonResult;
import com.fantasy.sangoUser.dto.ArticleDto;
import com.fantasy.sangoUser.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @GetMapping("/type/{type}")
    public CommonResult<List<ArticleDto>> getArticleByType(@PathVariable("type") String type){
        return new CommonResult<List<ArticleDto>>().success().data(articleService.getArticleByType(type));
    }
    @GetMapping("/id/{id}")
    public CommonResult<ArticleDto> getArticleById(@PathVariable("id") Integer id){
        return new CommonResult<ArticleDto>().success().data(articleService.getArticleById(id));
    }
    @GetMapping("/newest")
    public CommonResult<List<ArticleDto>> getNewestArticle(@RequestParam Integer num){
        return new CommonResult<List<ArticleDto>>().success().data(articleService.getNewestArticle(num));
    }
}
