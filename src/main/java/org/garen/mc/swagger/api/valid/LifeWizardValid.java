package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.LifeWizard;
import org.springframework.stereotype.Component;

/**
 * 生活向导参数验证类
 *
 * @author yanglimou
 * @create 2017/10/23 17:38
 * @since v1.0
 */
@Component
public class LifeWizardValid extends BaseValid {
    /**
     * 保存验证
     *
     * @param lifeWizard
     * @return
     */
    public String saveLifeWizardValid(LifeWizard lifeWizard) {
        if (lifeWizard == null)
            return paramNullMsg();
        if (StringUtils.isBlank(lifeWizard.getMd5()))
            return emptyMsg("图片");
        if (lifeWizard.getStatus() == null)
            return emptyMsg("状态");
        if (lifeWizard.getOrderBy() == null)
            return emptyMsg("排序");
        return null;
    }

    /**
     * 修改验证
     *
     * @param lifeWizard
     * @return
     */
    public String updateLifeWizardValid(LifeWizard lifeWizard) {
        if (lifeWizard == null)
            return paramNullMsg();
        if (lifeWizard.getId() == null)
            return emptyMsg("id");
        if (StringUtils.isBlank(lifeWizard.getMd5()))
            return emptyMsg("图片");
        if (lifeWizard.getStatus() == null)
            return emptyMsg("状态");
        if (lifeWizard.getOrderBy() == null)
            return emptyMsg("排序");
        return null;
    }
}
