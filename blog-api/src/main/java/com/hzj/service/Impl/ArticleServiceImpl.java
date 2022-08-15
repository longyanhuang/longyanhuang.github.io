package com.hzj.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzj.dao.mapper.ArticleMapper;
import com.hzj.dao.pojo.Article;
import com.hzj.service.ArticleService;
import com.hzj.vo.ArticleVo;
import com.hzj.vo.Result;
import com.hzj.vo.param.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.LanguageCallback;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    ArticleMapper articleMapper;
    @Override
    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        //先将数据按是否置顶以及创建日期来进行排序
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(records);
        return Result.success(articleVoList);
    }

    private List<ArticleVo> copyList(List<Article> records) {
      List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article record : records) {
            articleVoList.add(copy(record));
        }
        return articleVoList;
    }

    private ArticleVo copy(Article record) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(record,articleVo);
        articleVo.setCreateDate(new DateTime(record.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        return articleVo;
    }
}
