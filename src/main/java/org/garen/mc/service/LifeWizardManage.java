package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.LifeWizard;
import org.garen.mc.mybatis.domain.LifeWizardExample;
import org.garen.mc.mybatis.domain.Menu;
import org.garen.mc.mybatis.domain.MenuExample;
import org.garen.mc.mybatis.service.LifeWizardService;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生活向导业务类
 *
 * @author yanglimou
 * @create 2017/10/23 17:11
 * @since v1.0
 */
@Service
public class LifeWizardManage extends BaseManage<Long> {
    @Autowired
    private LifeWizardService<LifeWizard,LifeWizardExample,Long> lifeWizardService;
    @Override
    public  LifeWizardService<LifeWizard,LifeWizardExample,Long> getService() {
        return lifeWizardService;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteLifeWizard(Long id) {
        return removeById(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List<LifeWizard> getAll() {
        LifeWizardExample example=new LifeWizardExample();
        example.setOrderByClause("order_by,id desc");
        return findAll();
    }

    /**
     * 项目名查询
     * @param name
     * @return
     */
    public List<LifeWizard> getByName(String name) {
        LifeWizardExample lifeWizardExample=new LifeWizardExample();
        LifeWizardExample.Criteria criteria=lifeWizardExample.createCriteria();
        criteria.andNameLike("%"+ EsapiUtil.sql(name.trim())+"%");
        lifeWizardExample.setOrderByClause("order_by,id desc");
        return findListBy(lifeWizardExample);
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
        if (start == null) start = 0;
        if (length == null) length = 10;
        //构造查询条件
        LifeWizardExample lifeWizardExample=new LifeWizardExample();
        LifeWizardExample.Criteria criteria=lifeWizardExample.createCriteria();
        if (StringUtils.isNotBlank(name))
            criteria.andNameLike("%" + EsapiUtil.sql(name.trim()) + "%");
        lifeWizardExample.setOrderByClause("order_by,id desc");
        //查询
        List<LifeWizard> menus = getService().findBy(new RowBounds(start, length), lifeWizardExample);
        //构造查询sql
        String sql = "select count(*) count from menu where 1=1 ";
        if (StringUtils.isNotBlank(name)) {
            sql += " AND name like '%" + EsapiUtil.sql(name.trim()) + "%'";
        }
        //查询
        int count = getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", menus);
        map.put("count", count);
        return map;
    }

    /**
     * 状态查询
     * @param status
     * @return
     */
    public List<LifeWizard> getByStatus(Integer status) {
        LifeWizardExample lifeWizardExample=new LifeWizardExample();
        LifeWizardExample.Criteria criteria=lifeWizardExample.createCriteria();
        criteria.andStatusEqualTo(status);
        lifeWizardExample.setOrderByClause("order_by,id desc");
        return findListBy(lifeWizardExample);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public LifeWizard getById(Long id) {
        return findById(id);
    }

    /**
     * 保存
     * @param lifeWizard
     * @return
     */
    public int saveLifeWizard(org.garen.mc.swagger.model.LifeWizard lifeWizard) {
        lifeWizard.setId(null);
        LifeWizard lifeWizard1=tranfer(lifeWizard);
        return create(lifeWizard);
    }

    /**
     * 修改
     * @param lifeWizard
     * @return
     */
    public int updateLifeWizard(org.garen.mc.swagger.model.LifeWizard lifeWizard) {
        LifeWizard lifeWizard1=tranfer(lifeWizard);
        return modify(lifeWizard1);
    }

    /**
     * 实体类与参数类的转换工具
     * @param lifeWizard
     * @return
     */
    private LifeWizard tranfer(org.garen.mc.swagger.model.LifeWizard lifeWizard) {
        LifeWizard lifeWizard1=new LifeWizard();
        TransferUtil.transfer(lifeWizard1,lifeWizard);
        return  lifeWizard1;
    }
}
