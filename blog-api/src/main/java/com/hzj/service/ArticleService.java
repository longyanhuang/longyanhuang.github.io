package com.hzj.service;

import com.hzj.vo.Result;
import com.hzj.vo.param.PageParams;

public interface ArticleService {
    Result listArticle(PageParams pageParams);
}
