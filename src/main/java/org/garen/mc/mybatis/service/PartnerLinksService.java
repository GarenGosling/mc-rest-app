package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.CommonMapper;
import org.garen.mc.mybatis.mapper.PartnerLinksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by ylm on 2017/9/15.
 */
@Service
public class PartnerLinksService<T,Q,PK extends Serializable> extends  CommonsService <T,Q,PK>{
    @Autowired
    PartnerLinksMapper partnerLinksMapper;
    @Override
    public CommonMapper<T, Q, PK> getMapper() {
        return partnerLinksMapper;
    }
}
