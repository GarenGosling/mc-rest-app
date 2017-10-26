package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.ArticleDetail;
import org.garen.mc.mybatis.domain.ArticleDetailExample;

public interface ArticleDetailMapper<T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK> {
    long countByExample(ArticleDetailExample example);

    int deleteByExample(ArticleDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleDetail record);

    int insertSelective(ArticleDetail record);

    List<ArticleDetail> selectByExample(ArticleDetailExample example);

    ArticleDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleDetail record, @Param("example") ArticleDetailExample example);

    int updateByExample(@Param("record") ArticleDetail record, @Param("example") ArticleDetailExample example);

    int updateByPrimaryKeySelective(ArticleDetail record);

    int updateByPrimaryKey(ArticleDetail record);
}