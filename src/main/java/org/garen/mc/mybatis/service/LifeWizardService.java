package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.CommonMapper;
import org.garen.mc.mybatis.mapper.LifeWizardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/23 17:09
 * @since v1.0
 */
@Service
public class LifeWizardService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private LifeWizardMapper<T, Q, PK> lifeWizardMapper;
    @Override
    public LifeWizardMapper<T, Q, PK> getMapper() {
        return lifeWizardMapper;
    }
}
