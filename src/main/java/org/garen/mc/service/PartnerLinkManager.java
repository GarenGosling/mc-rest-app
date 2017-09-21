package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.PartnerLink;
import org.garen.mc.mybatis.domain.PartnerLinkExample;
import org.garen.mc.mybatis.service.PartnerLinkService;
import org.garen.mc.service.validate.PartnerLinkValidate;
import org.garen.mc.swagger.model.SuccessModel;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ylm on 2017/9/19.
 */
@Service
public class PartnerLinkManager extends BaseManage<Integer>{
    private static final String SAVE_SUCCESS = "新增合作链接成功,新增数量： ";
    private static final String DELETE_SUCCESS = "删除合作链接成功，删除数量： ";
    private static final String UPDATE_SUCCESS = "修改合作链接成功，修改数量： ";
    private static final String CODE_FIND_SUCCESS = "按照编码查询成功";
    private static final String NAME_FIND_SUCCESS = "按照名称查询成功";
    private static final String STATUS_FIND_SUCCESS = "按照状态查询成功";
    private static final String GET_SUCCESS = "ID查询成功";
    private static final String GET_PAGE_SUCCESS = "分页查询全部成功";
    private static final Integer START = 0;
    private static final Integer LENGTH = 10;
    @Autowired
    private PartnerLinkService<PartnerLink,PartnerLinkExample,Integer> partnerLinkService;
    @Autowired
    private PartnerLinkValidate partnerLinkValidate;
    @Override
    public PartnerLinkService<PartnerLink, PartnerLinkExample, Integer> getService() {
        return partnerLinkService;
    }
    /*
    删除
     */
    public SuccessModel deletePartnerLink(Integer id) {
        // 验证
        SuccessModel successModel=partnerLinkValidate.idValidate(id);
        if(successModel!=null)
            return  successModel;
        int i=removeById(id);
        return new SuccessModel().message(DELETE_SUCCESS+i);
    }
    /*
    查询全部
     */
    public SuccessModel getAll() {
        return new SuccessModel().message(GET_ALL_SUCCESS).data(getService().findAll());
    }
    /*
    保存
     */
    public SuccessModel savePartnerLink(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        //验证
        SuccessModel successModel=partnerLinkValidate.savePartnerLinkValidate(partnerLink);
        if(successModel!=null)
            return  successModel;
        //去掉无用或者不应该传递的参数
        partnerLink.setId(null);
        partnerLink.setCode(null);
        //类型转换
        org.garen.mc.mybatis.domain.PartnerLink partnerLink1=tranfer(partnerLink);

        //处理业务
        partnerLink1.setCode(CodeGenerateUtils.getRandomCode());
        partnerLink1.setCreateTime(new Date());
        int i=create(partnerLink1);
        return new SuccessModel().message(SAVE_SUCCESS+i);
    }
    /*
    修改
     */
    public SuccessModel updatePartnerLink(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        //验证
        SuccessModel successModel=partnerLinkValidate.updatePartnerLinkValidate(partnerLink);
        if(successModel!=null)
            return  successModel;
        //去掉无用参数
        partnerLink.setCode(null);
        //类型转换
        PartnerLink partnerLink1=tranfer(partnerLink);
        //处理业务
        int i=modify(partnerLink1);
        return new SuccessModel().message(UPDATE_SUCCESS+i);
    }
    /*
     按照编码查询成功
     */
    public SuccessModel getByCode(String code) {
        SuccessModel successModel=partnerLinkValidate.getByCodeValidate(code);
        if(successModel!=null)
            return successModel;
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andCodeEqualTo(EsapiUtil.sql(code));
        PartnerLink partnerLink=getService().findByOne(example);
        return new SuccessModel().data(partnerLink).message(CODE_FIND_SUCCESS);
    }

    public SuccessModel getByName(String name) {
        SuccessModel successModel=partnerLinkValidate.getByNameValidate(name);
        if(successModel!=null)
            return successModel;
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike("%"+EsapiUtil.sql(name.trim())+"%");
        PartnerLink partnerLink=getService().findByOne(example);
        return new SuccessModel().data(partnerLink).message(NAME_FIND_SUCCESS);
    }

    public SuccessModel getByPage(Integer start, Integer length, String name) {
        if(start==null) start=START;
        if(length==null) length=LENGTH;
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(name))
            criteria.andNameLike("%"+EsapiUtil.sql(name.trim())+"%");
        example.setOrderByClause("id desc");
        List<PartnerLink> partnerLinks=getService().findBy(new RowBounds(start,length),example);
        String sql = "select count(*) count from partner_link where 1=1 ";
        if(StringUtils.isNotBlank(name)){
            sql += " AND name like '%"+ EsapiUtil.sql(name) +"%'";
        }
        int count=getService().countBySQL(sql);
        Map map = new HashMap();
        map.put("list", partnerLinks);
        map.put("count", count);
        return new SuccessModel().message(GET_PAGE_SUCCESS).data(map);
    }

    public SuccessModel getByStatus(Integer status) {
        SuccessModel successModel=partnerLinkValidate.getByStatusValidate(status);
        if(successModel!=null)
            return successModel;
        PartnerLinkExample example=new PartnerLinkExample();
        PartnerLinkExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo(status);
        List<PartnerLink> partnerLinks=getService().findBy(example);
        return new SuccessModel().data(partnerLinks).message(STATUS_FIND_SUCCESS);
    }

    public SuccessModel getPartnerLink(Integer id) {
        SuccessModel successModel=partnerLinkValidate.idValidate(id);
        if(successModel!=null)
            return  successModel;
        PartnerLink partnerLink=findById(id);
        return new SuccessModel().data(partnerLink).message(GET_SUCCESS);
    }


    /*
    实体类与参数封装类装换
     */
    private PartnerLink tranfer(org.garen.mc.swagger.model.PartnerLink partnerLink) {
        PartnerLink partnerLink1=new org.garen.mc.mybatis.domain.PartnerLink();
        TransferUtil.transfer(partnerLink1,partnerLink);
        return  partnerLink1;
    }



}
