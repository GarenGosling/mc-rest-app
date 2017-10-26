package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.MoreAttentionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/26 23:49
 * @since v1.0
 */
@Service
public class MoreAttentionService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private MoreAttentionMapper<T, Q, PK> moreAttentionMapper;
    @Override
    public MoreAttentionMapper<T, Q, PK> getMapper() {
        return moreAttentionMapper;
    }
}
