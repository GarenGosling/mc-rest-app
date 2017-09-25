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
     * 保存验证参数
     * @param partnerLink
     * @return
     */
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

    /**
     * 修改验证参数
     * @param partnerLink
     * @return
     */
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
