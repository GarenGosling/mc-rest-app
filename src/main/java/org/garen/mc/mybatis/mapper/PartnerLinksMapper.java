package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.PartnerLinks;
import org.garen.mc.mybatis.domain.PartnerLinksExample;

public interface PartnerLinksMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK> {
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