package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.domain.Article;
import org.garen.mc.mybatis.domain.ArticleDetailExample;
import org.garen.mc.mybatis.domain.ArticleExample;
import org.garen.mc.mybatis.mapper.ArticleMapper;
import org.garen.mc.mybatis.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/24 11:26
 * @since v1.0
 */
@Service
public class ArticleService <T,Q,PK extends Serializable> extends CommonsService<T, Q,PK>{
    @Autowired
    private ArticleMapper<T, Q, PK> articleMapper;
    @Override
    public ArticleMapper<T, Q, PK> getMapper() {
        return articleMapper;
    }


}
