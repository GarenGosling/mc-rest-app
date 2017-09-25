package org.garen.mc.mybatis.service;

import org.garen.mc.mybatis.mapper.CarouselMapper;
import org.garen.mc.mybatis.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/9/25 15:03
 * @since v1.0
 */
@Service
public class CarouselService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    private CarouselMapper<T, Q, PK>  carouselMapper;
    @Override
    public CarouselMapper<T, Q, PK> getMapper() {
        return carouselMapper;
    }
}
