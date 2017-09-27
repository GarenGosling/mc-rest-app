package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.Carousel;
import org.garen.mc.mybatis.domain.CarouselExample;
import org.garen.mc.mybatis.domain.PartnerLink;
import org.garen.mc.mybatis.domain.PartnerLinkExample;
import org.garen.mc.mybatis.service.CarouselService;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页轮播图业务类
 *
 * @author yanglimou
 * @create 2017/9/25 15:05
 * @since v1.0
 */
@Service
public class CarouselManage extends BaseManage<Integer> {
    @Autowired
    private CarouselService<Carousel,CarouselExample,Integer> carouselService;
    @Override
    public CarouselService<Carousel,CarouselExample,Integer> getService() {
        return carouselService;
    }

    /**
     * id删除
     * @param id
     * @return
     */
    public int deleteCarousel(Integer id) {
        return removeById(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List<Carousel> getAll() {
        return findAll();
    }

    /**
     * 描述查询
     * @param description
     * @return
     */
    public List<Carousel> getByDescription(String description) {
        if(StringUtils.isNotBlank(description)) {
            CarouselExample example = new CarouselExample();
            CarouselExample.Criteria criteria = example.createCriteria();
            criteria.andDescriptionLike("%"+ EsapiUtil.sql(description.trim())+"%");
            return findListBy(example);
        }
        return getAll();
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param description
     * @return
     */
    public Map getByPage(Integer start, Integer length, String description) {
        //初始化参数
        if(start==null) start=0;
        if(length==null) length=10;
        //构造查询条件
        CarouselExample example = new CarouselExample();
        CarouselExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(description))
            criteria.andDescriptionLike("%"+ EsapiUtil.sql(description.trim())+"%");
        example.setOrderByClause("id desc");
        //查询
        List<Carousel> carousels= getService().findBy(new RowBounds(start, length), example);
        //构造查询sql
        String sql = "select count(*) count from carousel where 1=1 ";
        if(StringUtils.isNotBlank(description)){
            sql += " AND description like '%"+ EsapiUtil.sql(description) +"%'";
        }
        //查询
        int count=getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", carousels);
        map.put("count", count);
        return map;
    }

    /**
     * 状态和位置查询
     * @param status
     * @return
     */
    public List<Carousel> getByStatusAndPlace(Integer status, String place) {
        CarouselExample example = new CarouselExample();
        CarouselExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andPlaceEqualTo(place);
        example.setOrderByClause("order_by,id desc");
        return findListBy(example);
    }


    /**
     * id查询
     * @param id
     * @return
     */
    public Carousel getById(Integer id) {
        return findById(id);
    }

    /**
     * 保存
     * @param carousel
     * @return
     */
    public int saveCarousel(org.garen.mc.swagger.model.Carousel carousel) {
        //去掉无用参数
        carousel.setId(null);
        //类型转换
        Carousel carousel1=tranfer(carousel);
        //保存
        carousel1.setCreateTime(new Date());
        return create(carousel1);
    }

    /**
     * 删除
     * @param carousel
     * @return
     */
    public int updateCarousel(org.garen.mc.swagger.model.Carousel carousel) {
        //类型转换
        Carousel carousel1=tranfer(carousel);
        return modify(carousel1);
    }

    /**
     * 实体类与参数类的转换工具
     * @param carousel
     * @return
     */
    private Carousel tranfer(org.garen.mc.swagger.model.Carousel carousel) {
       Carousel carousel1=new Carousel();
        TransferUtil.transfer(carousel1,carousel);
        return  carousel1;
    }


}
