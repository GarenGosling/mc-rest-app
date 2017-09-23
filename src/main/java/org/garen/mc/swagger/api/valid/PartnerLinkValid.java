package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.PartnerLink;
import org.springframework.stereotype.Component;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/9/23 20:10
 * @since v1.0
 */
@Component
public class PartnerLinkValid extends BaseValid {

    /**
     * ID查询、删除文件类型，验证参数
     *
     * @param id
     * @return
     */
    public String idValid(Integer id){
        if(id == null)
            return emptyMsg("id");
        return null;
    }

    /**
     * 编码查询文件类型，验证参数
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
     * 名称查询文件类型，验证参数
     *
     * @param name
     * @return
     */
    public String nameValid(String name){
        if(StringUtils.isBlank(name))
            return emptyMsg("name");
        return null;
    }
    public String statusValid(Integer status) {
        if(status==null)
            return  emptyMsg("status");
        return  null;
    }

    public String savePartnerLinkValid(PartnerLink partnerLink) {
        if(partnerLink==null)
            return paramNullMsg();
        if(StringUtils.isBlank(partnerLink.getName()))
            return  emptyMsg("名称");
        if(StringUtils.isBlank(partnerLink.getUrl()))
            return  emptyMsg("链接");
        if(StringUtils.isBlank(partnerLink.getMd5()))
            return  emptyMsg("图片");
        if(partnerLink.getStatus()==null)
            return  emptyMsg("状态");
        return  null;
    }

    public String updatePartnerLinkValid(PartnerLink partnerLink) {
        if(partnerLink==null)
            return paramNullMsg();
        if(partnerLink.getId()==null)
            return emptyMsg("id");
        if(StringUtils.isBlank(partnerLink.getName()))
            return  emptyMsg("名称");
        if(StringUtils.isBlank(partnerLink.getUrl()))
            return  emptyMsg("链接");
        if(StringUtils.isBlank(partnerLink.getMd5()))
            return  emptyMsg("图片");
        if(partnerLink.getStatus()==null)
            return  emptyMsg("状态");
        return  null;
    }
}
