package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.Menu;
import org.garen.mc.mybatis.domain.MenuExample;
import org.garen.mc.mybatis.domain.PartnerLink;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.mybatis.service.MenuService;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单业务类
 *
 * @author yanglimou
 * @create 2017/10/11 6:35
 * @since v1.0
 */
@Service
public class MenuManage extends BaseManage<Integer> {
    @Autowired
    private MenuService<Menu, MenuExample, Integer> menuService;

    @Override
    public MenuService<Menu, MenuExample, Integer> getService() {
        return menuService;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deletePartnerLink(Integer id) {
        return removeById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Menu> getAll() {
        return getService().findAll();
    }

    /**
     * 编码查询
     *
     * @param code
     * @return
     */
    public Menu getByCode(String code) {
        //构造查询条件
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andCodeEqualTo(EsapiUtil.sql(code));
        //查询
        return getService().findByOne(menuExample);
    }

    /**
     * 级别查询
     *
     * @param level
     * @return
     */
    public List<Menu> getByLevel(Integer level) {
        //构造查询条件
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andLevelEqualTo(level);
        //查询
        return getService().findBy(menuExample);
    }

    /**
     * 名称查询
     *
     * @param name
     * @return
     */
    public List<Menu> getByName(String name) {
        //构造查询条件
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andNameLike(EsapiUtil.sql("%" + name.trim() + "%"));
        //查询
        return getService().findBy(menuExample);
    }

    /**
     * 父级菜单编码查询
     *
     * @param pCode
     * @return
     */
    public List<Menu> getByPatentCode(String pCode, Integer status) {
        //构造查询条件
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andParentCodeEqualTo(EsapiUtil.sql(pCode));
        if (status != null)
            criteria.andStatusEqualTo(status);
        menuExample.setOrderByClause("order_by asc");
        //查询
        return getService().findBy(menuExample);
    }

    /**
     * 分页查询
     *
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
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        if (StringUtils.isNotBlank(name))
            criteria.andNameLike("%" + EsapiUtil.sql(name.trim()) + "%");
        menuExample.setOrderByClause("id desc");
        //查询
        List<Menu> menus = getService().findBy(new RowBounds(start, length), menuExample);
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
     * id查询
     *
     * @param id
     * @return
     */
    public Menu getMenu(Integer id) {
        return findById(id);
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
    public int saveMenu(org.garen.mc.swagger.model.Menu menu) {
        //去掉无用或者不应该传递的参数
        menu.setId(null);
        menu.setCode(null);
        //类型转换
        org.garen.mc.mybatis.domain.Menu menu1 = tranfer(menu);
        //保存
        menu1.setCode(CodeGenerateUtils.getRandomCode());
        menu1.setCreateTime(new Date());
        return create(menu1);
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
    public int updateMenu(org.garen.mc.swagger.model.Menu menu) {
        //去掉无用参数
        menu.setCode(null);
        //类型转换
        Menu menu1 = tranfer(menu);
        //修改
        return modify(menu1);
    }

    /**
     * 实体类与参数类的转换工具
     *
     * @param menu
     * @return
     */
    private Menu tranfer(org.garen.mc.swagger.model.Menu menu) {
        Menu menu1 = new org.garen.mc.mybatis.domain.Menu();
        TransferUtil.transfer(menu1, menu);
        return menu1;
    }

}
