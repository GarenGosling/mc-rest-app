package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.CommentMapper;
import org.garen.mc.mybatis.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/31 9:14
 * @since v1.0
 */
@Service
public class CommentService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK>  {
    @Autowired
    private CommentMapper<T,Q,PK> commentMapper;
    @Override
    public CommentMapper<T, Q, PK> getMapper() {
        return commentMapper;
    }
}
