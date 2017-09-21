package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.PartnerLink;
import org.garen.mc.mybatis.domain.PartnerLinkExample;

public interface PartnerLinkMapper<T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK> {
    long countByExample(PartnerLinkExample example);

    int deleteByExample(PartnerLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartnerLink record);

    int insertSelective(PartnerLink record);

    List<PartnerLink> selectByExample(PartnerLinkExample example);

    PartnerLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartnerLink record, @Param("example") PartnerLinkExample example);

    int updateByExample(@Param("record") PartnerLink record, @Param("example") PartnerLinkExample example);

    int updateByPrimaryKeySelective(PartnerLink record);

    int updateByPrimaryKey(PartnerLink record);
}