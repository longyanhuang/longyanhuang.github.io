package com.hzj.controller;

import com.hzj.dao.pojo.Article;
import com.hzj.service.ArticleService;
import com.hzj.vo.Result;
import com.hzj.vo.param.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle(pageParams);

    }
}
