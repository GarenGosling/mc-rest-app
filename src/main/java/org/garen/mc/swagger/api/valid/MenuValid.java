package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.Menu;
import org.springframework.stereotype.Component;

/**
 * 菜单验证类
 *
 * @author yanglimou
 * @create 2017/10/11 8:47
 * @since v1.0
 */
@Component
public class MenuValid extends BaseValid{
    /**
     * 级别验证
     * @param level
     * @return
     */
    public String levelValid(Integer level) {
        if(level==null)
            return  emptyMsg("level");
        return  null;
    }

    /**
     * 父菜单编码验证
     * @param pCode
     * @return
     */
    public String parentCodeValid(String pCode) {
        if(StringUtils.isBlank(pCode))
            return  emptyMsg("pCode");
        return  null;
    }

    /**
     * 保存验证
     * @param menu
     * @return
     */
    public String saveMenuValid(Menu menu) {
        if(menu==null)
            return paramNullMsg();
        if(StringUtils.isBlank(menu.getName()))
            return  emptyMsg("名称");
//        if(StringUtils.isBlank(menu.getUrl()))
//            return  emptyMsg("链接");
        if(menu.getStatus()==null)
            return  emptyMsg("状态");
        if(menu.getLevel()==null)
            return  emptyMsg("级别");
        if(StringUtils.isBlank(menu.getParentCode()))
            return  emptyMsg("父菜单编码");
        if(menu.getOrderBy()==null)
            return  emptyMsg("排列顺序");
        return  null;
    }

    public String updateMenuValid(Menu menu) {
        if(menu==null)
            return paramNullMsg();
        if(menu.getId()==null)
            return emptyMsg("id");
        if(StringUtils.isBlank(menu.getName()))
            return  emptyMsg("名称");
//        if(StringUtils.isBlank(menu.getUrl()))
//            return  emptyMsg("链接");
        if(menu.getStatus()==null)
            return  emptyMsg("状态");
        if(menu.getLevel()==null)
            return  emptyMsg("级别");
        if(StringUtils.isBlank(menu.getParentCode()))
            return  emptyMsg("父菜单编码");
        if(menu.getOrderBy()==null)
            return  emptyMsg("排列顺序");
        return  null;
    }
}
