package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.AuthorMapper;
import org.garen.mc.mybatis.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Service
public class AuthorService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private AuthorMapper<T, Q, PK> authorMapper;
    @Override
    public AuthorMapper<T, Q, PK> getMapper() {
        return authorMapper;
    }
}
