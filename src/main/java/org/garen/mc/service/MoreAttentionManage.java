package org.garen.mc.service;

import org.garen.mc.mybatis.domain.*;
import org.garen.mc.mybatis.domain.MoreAttention;
import org.garen.mc.mybatis.domain.MoreAttentionExample;
import org.garen.mc.mybatis.service.MoreAttentionService;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 更多关注业务类
 *
 * @author yanglimou
 * @create 2017/10/26 23:51
 * @since v1.0
 */
@Service
public class MoreAttentionManage extends BaseManage<Long> {
    @Autowired
    private MoreAttentionService<MoreAttention,MoreAttentionExample,Long> moreAttentionService;
    @Override
    public MoreAttentionService<MoreAttention, MoreAttentionExample, Long> getService() {
        return moreAttentionService;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteMoreAttention(Long id) {
        //删除
        return removeById(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List<MoreAttention> getAll() {
        //查询
        MoreAttentionExample example=new MoreAttentionExample();
        example.setOrderByClause("id desc");
        return findListBy(example);
    }

    /**
     * 状态查询
     * @param status
     * @return
     */
    public List<MoreAttention> getByStatus(Integer status) {
        //构造查询条件
        MoreAttentionExample example=new MoreAttentionExample();
        MoreAttentionExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo(status);
        example.setOrderByClause("id desc");
        //查询
        return getService().findBy(example);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public MoreAttention getMoreAttention(Long id) {
        //查询
        return findById(id);
    }

    /**
     * 保存
     * @param moreAttention
     * @return
     */
    public int saveMoreAttention(org.garen.mc.swagger.model.MoreAttention moreAttention) {
        //类型转换
        org.garen.mc.mybatis.domain.MoreAttention moreAttention1=tranfer(moreAttention);
        //保存
        return create(moreAttention1);
    }

    /**
     * 修改
     * @param moreAttention
     * @return
     */
    public int updateMoreAttention(org.garen.mc.swagger.model.MoreAttention moreAttention) {
        //类型转换
        MoreAttention moreAttention1=tranfer(moreAttention);
        //修改
        return modify(moreAttention1);
    }
    /**
     * 实体类与参数类的转换工具
     * @param moreAttention
     * @return
     */
    private MoreAttention tranfer(org.garen.mc.swagger.model.MoreAttention moreAttention) {
        MoreAttention moreAttention1=new org.garen.mc.mybatis.domain.MoreAttention();
        TransferUtil.transfer(moreAttention1,moreAttention);
        return  moreAttention1;
    }
}
