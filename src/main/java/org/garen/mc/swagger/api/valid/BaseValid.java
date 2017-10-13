package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;

/**
 * 验证父类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:09
 * @since v1.0
 */
public class BaseValid {
    /**
     * 不能为空
     */
    public final String NOT_EMPTY = "不能为空";

    /**
     * str不能为空
     *
     * @param str
     * @return
     */
    public String emptyMsg(String str){
        return str + NOT_EMPTY;
    }

    /**
     * 参数不能为空
     *
     * @return
     */
    public String paramNullMsg(){
        return "参数" + NOT_EMPTY;
    }


    /**
     * ID查询、删除，验证参数
     *
     * @param id
     * @return
     */
    public String idValid(Long id){
        if(id == null)
            return emptyMsg("id");
        return null;
    }

    /**
     * 编码查询，验证参数
     *
     * @param code
     * @return
     */
    public String codeValid(String code){
        if(StringUtils.isBlank(code))
            return emptyMsg("code");
        return null;
    }

    /**
     * 名称查询，验证参数
     *
     * @param name
     * @return
     */
    public String nameValid(String name){
        if(StringUtils.isBlank(name))
            return emptyMsg("name");
        return null;
    }

    /**
     * 状态验证参数
     * @param status
     * @return
     */
    public String statusValid(Integer status) {
        if(status==null)
            return  emptyMsg("status");
        return  null;
    }

    /**
     * 位置验证参数
     * @param place
     * @return
     */
    public String placeValid(String place) {
        if(StringUtils.isBlank(place))
            return  emptyMsg("place");
        return  null;
    }


}
