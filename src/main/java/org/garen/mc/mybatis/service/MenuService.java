package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.CommonMapper;
import org.garen.mc.mybatis.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/11 6:33
 * @since v1.0
 */
@Service
public class MenuService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private MenuMapper<T, Q, PK> menuMapper;
    @Override
    public MenuMapper<T, Q, PK> getMapper() {
        return menuMapper;
    }
}
