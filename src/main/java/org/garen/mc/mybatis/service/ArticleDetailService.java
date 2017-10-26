package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.domain.ArticleDetailExample;
import org.garen.mc.mybatis.mapper.ArticleDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/24 11:26
 * @since v1.0
 */
@Service
public class ArticleDetailService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private ArticleDetailMapper<T, Q, PK> articleDetailMapper;
    @Override
    public ArticleDetailMapper<T, Q, PK> getMapper() {
        return articleDetailMapper;
    }

}
