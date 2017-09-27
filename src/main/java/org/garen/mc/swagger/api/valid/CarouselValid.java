package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.Carousel;
import org.springframework.stereotype.Component;

/**
 * 首页轮播图验证类
 *
 * @author yanglimou
 * @create 2017/9/25 15:29
 * @since v1.0
 */
@Component
public class CarouselValid extends  BaseValid {
    /**
     * 保存参数验证
     * @param carousel
     * @return
     */
    public String saveCarouselValid(Carousel carousel) {
        if(carousel==null)
            return paramNullMsg();
        if(StringUtils.isBlank(carousel.getMd5()))
            return  emptyMsg("图片");
        if(carousel.getStatus()==null)
            return  emptyMsg("状态");
        if(StringUtils.isBlank(carousel.getPlace()))
            return  emptyMsg("位置");
        if(carousel.getOrderBy()==null)
            return  emptyMsg("排序");
        return  null;
    }

    /**
     * 修改参数验证
     * @param carousel
     * @return
     */
    public String updateCarouselValid(Carousel carousel) {
        if(carousel==null)
            return paramNullMsg();
        if(carousel.getId()==null)
            return emptyMsg("id");
        if(StringUtils.isBlank(carousel.getMd5()))
            return  emptyMsg("图片");
        if(carousel.getStatus()==null)
            return  emptyMsg("状态");
        if(StringUtils.isBlank(carousel.getPlace()))
            return  emptyMsg("位置");
        if(carousel.getOrderBy()==null)
            return  emptyMsg("排序");
        return  null;
    }
}
