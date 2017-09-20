package org.garen.mc.service.validate;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.PartnerLink;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.stereotype.Component;

/**
 * PartnerLinkManager的验证类
 * Created by ylm on 2017/9/19.
 */
@Component
public class PartnerLinkValidate extends BaseValidate {

    public SuccessModel savePartnerLinkValidate(PartnerLink partnerLink) {
        if(partnerLink==null)
            return validateFailResponse();
        if(StringUtils.isBlank(partnerLink.getName()))
            return  validateFailResponse("名称");
        if(StringUtils.isBlank(partnerLink.getUrlMd5()))
            return  validateFailResponse("链接");
        return  null;
    }

    public SuccessModel idValidate(Integer id) {
        if(id==null)
            return validateFailResponse("id");
        return null;
    }

    public SuccessModel updatePartnerLinkValidate(PartnerLink partnerLink) {
        if(partnerLink==null)
            return  validateFailResponse("修改的参数");
        if(partnerLink.getId()==null||partnerLink.getId()==0)
            return  validateFailResponse("id");
        if(StringUtils.isBlank(partnerLink.getName())||StringUtils.isBlank(partnerLink.getUrlMd5()))
            return validateFailResponse("修改的参数");
        return  null;
    }

    public SuccessModel getByCodeValidate(String code) {
        if(StringUtils.isBlank(code))
            return  validateFailResponse("查询参数为空");
        return  null;
    }

    public SuccessModel getByNameValidate(String name) {
        if(StringUtils.isBlank(name))
            return  validateFailResponse("查询参数为空");
        return  null;
    }
}
