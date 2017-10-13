package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.PartnerLink;
import org.garen.mc.mybatis.domain.PartnerLinkExample;
import org.garen.mc.mybatis.service.PartnerLinkService;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 合作链接业务类
 *
 * @author yanglimou
 * @create 2017/9/23 11:52
 * @since v1.0
 */
@Service
public class PartnerLinkManage extends BaseManage<Long>{
    @Autowired
    private PartnerLinkService<PartnerLink,PartnerLinkExample,Long> partnerLinkService;
    @Override
    public PartnerLinkService<PartnerLink, PartnerLinkExample, Long> getService() {
        return partnerLinkService;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deletePartnerLink(Long id) {
        //删除
        return removeById(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List<PartnerLink> getAll() {
        //查询
        return getService().findAll();
    }

    /**
     * 保存
     * @param partnerLink
     * @return
     */
    public int savePartnerLink(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        //去掉无用或者不应该传递的参数
        partnerLink.setId(null);
        partnerLink.setCode(null);
        //类型转换
        org.garen.mc.mybatis.domain.PartnerLink partnerLink1=tranfer(partnerLink);

        //保存
        partnerLink1.setCode(CodeGenerateUtils.getRandomCode());
        partnerLink1.setCreateTime(new Date());
        return create(partnerLink1);
    }

    /**
     * 修改
     * @param partnerLink
     * @return
     */
    public int updatePartnerLink(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        //去掉无用参数
        partnerLink.setCode(null);
        //类型转换
        PartnerLink partnerLink1=tranfer(partnerLink);
        //修改
        return modify(partnerLink1);
    }

    /**
     * 按照编码查询
     * @param code
     * @return
     */
    public PartnerLink getByCode(String code) {
        //构造查询条件
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andCodeEqualTo(EsapiUtil.sql(code));
        //查询
        return getService().findByOne(example);
    }

    /**
     * 按照名字查询
     * @param name
     * @return
     */
    public List<PartnerLink> getByName(String name) {
        //构造查询条件
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike("%"+EsapiUtil.sql(name.trim())+"%");
        //查询
        return getService().findBy(example);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param name
     * @return
     */
    public Map getByPage(Integer start, Integer length, String name) {
        //初始化参数
        if(start==null) start=0;
        if(length==null) length=10;
        //构造查询条件
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(name))
            criteria.andNameLike("%"+EsapiUtil.sql(name.trim())+"%");
        example.setOrderByClause("id desc");
        //查询
        List<PartnerLink> partnerLinks=getService().findBy(new RowBounds(start,length),example);
        //构造查询sql
        String sql = "select count(*) count from partner_link where 1=1 ";
        if(StringUtils.isNotBlank(name)){
            sql += " AND name like '%"+ EsapiUtil.sql(name.trim()) +"%'";
        }
        //查询
        int count=getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", partnerLinks);
        map.put("count", count);
        return map;
    }

    /**
     * 按照状态查询
     * @param status
     * @return
     */
    public List<PartnerLink> getByStatus(Integer status) {
        //构造查询条件
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo(status);
        //查询
        return getService().findBy(example);
    }

    /**
     * 按照id查询
     * @param id
     * @return
     */
    public PartnerLink getPartnerLink(Long id) {
        //查询
        return findById(id);
    }


    /**
     * 实体类与参数类的转换工具
     * @param partnerLink
     * @return
     */
    private PartnerLink tranfer(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        PartnerLink partnerLink1=new org.garen.mc.mybatis.domain.PartnerLink();
        TransferUtil.transfer(partnerLink1,partnerLink);
        return  partnerLink1;
    }
}
