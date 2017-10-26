package org.garen.mc.mybatis.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.garen.mc.mybatis.domain.LifeWizard;
import org.garen.mc.mybatis.domain.LifeWizardExample;

public interface LifeWizardMapper<T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK> {
    long countByExample(LifeWizardExample example);

    int deleteByExample(LifeWizardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LifeWizard record);

    int insertSelective(LifeWizard record);

    List<LifeWizard> selectByExample(LifeWizardExample example);

    LifeWizard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LifeWizard record, @Param("example") LifeWizardExample example);

    int updateByExample(@Param("record") LifeWizard record, @Param("example") LifeWizardExample example);

    int updateByPrimaryKeySelective(LifeWizard record);

    int updateByPrimaryKey(LifeWizard record);
}