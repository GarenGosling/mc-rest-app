package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.MoreAttention;
import org.garen.mc.mybatis.domain.MoreAttentionExample;

public interface MoreAttentionMapper<T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK> {
    long countByExample(MoreAttentionExample example);

    int deleteByExample(MoreAttentionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MoreAttention record);

    int insertSelective(MoreAttention record);

    List<MoreAttention> selectByExample(MoreAttentionExample example);

    MoreAttention selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MoreAttention record, @Param("example") MoreAttentionExample example);

    int updateByExample(@Param("record") MoreAttention record, @Param("example") MoreAttentionExample example);

    int updateByPrimaryKeySelective(MoreAttention record);

    int updateByPrimaryKey(MoreAttention record);
}