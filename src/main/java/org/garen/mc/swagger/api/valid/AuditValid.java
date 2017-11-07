package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.Audit;
import org.springframework.stereotype.Component;

/**
 * 审核验证类
 *
 * @author yanglimou
 * @create 2017/11/4 1:52
 * @since v1.0
 */
@Component
public class AuditValid extends BaseValid{
    /**
     * 验证
     * @param audit
     * @return
     */
    public String auditValid(Audit audit) {
        if(audit.getId()==null)
            return emptyMsg("id");
        if(audit.getStatus()==null)
            return emptyMsg("status");
        if(audit.getStatus()==2 && StringUtils.isBlank(audit.getRemark()))
            return emptyMsg("remark");
        return null;
    }
}
