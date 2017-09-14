package org.garen.mc.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.CooperativeBrand;
import org.garen.mc.mybatis.domain.CooperativeBrandExample;

public interface CooperativeBrandMapper {
    long countByExample(CooperativeBrandExample example);

    int deleteByExample(CooperativeBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CooperativeBrand record);

    int insertSelective(CooperativeBrand record);

    List<CooperativeBrand> selectByExample(CooperativeBrandExample example);

    CooperativeBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CooperativeBrand record, @Param("example") CooperativeBrandExample example);

    int updateByExample(@Param("record") CooperativeBrand record, @Param("example") CooperativeBrandExample example);

    int updateByPrimaryKeySelective(CooperativeBrand record);

    int updateByPrimaryKey(CooperativeBrand record);
}