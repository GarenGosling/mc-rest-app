package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.PartnerLinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by ylm on 2017/9/19.
 */

@Service
public class PartnerLinkService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private PartnerLinkMapper<T, Q, PK> partnerLinkMapper;
    @Override
    public PartnerLinkMapper<T, Q, PK> getMapper() {
        return partnerLinkMapper;
    }
}
