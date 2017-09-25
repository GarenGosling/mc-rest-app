package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.Carousel;
import org.garen.mc.mybatis.domain.CarouselExample;

public interface CarouselMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK>{
    long countByExample(CarouselExample example);

    int deleteByExample(CarouselExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    List<Carousel> selectByExample(CarouselExample example);

    Carousel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByExample(@Param("record") Carousel record, @Param("example") CarouselExample example);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);
}