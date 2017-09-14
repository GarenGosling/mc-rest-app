package org.garen.mc.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.PartnerLinks;
import org.garen.mc.mybatis.domain.PartnerLinksExample;

public interface PartnerLinksMapper {
    long countByExample(PartnerLinksExample example);

    int deleteByExample(PartnerLinksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartnerLinks record);

    int insertSelective(PartnerLinks record);

    List<PartnerLinks> selectByExample(PartnerLinksExample example);

    PartnerLinks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartnerLinks record, @Param("example") PartnerLinksExample example);

    int updateByExample(@Param("record") PartnerLinks record, @Param("example") PartnerLinksExample example);

    int updateByPrimaryKeySelective(PartnerLinks record);

    int updateByPrimaryKey(PartnerLinks record);
}