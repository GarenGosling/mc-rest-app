package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.MoreAttention;
import org.springframework.stereotype.Component;

/**
 * 更多关注验证类
 *
 * @author yanglimou
 * @create 2017/10/27 0:05
 * @since v1.0
 */
@Component
public class MoreAttentionValid extends BaseValid {
    /**
     * 保存验证
     * @param moreAttention
     * @return
     */
    public String saveMoreAttentionValid(MoreAttention moreAttention) {
        if(moreAttention==null)
            return paramNullMsg();
        if(StringUtils.isBlank(moreAttention.getUrl()))
            return  emptyMsg("链接");
        if(StringUtils.isBlank(moreAttention.getMd5()))
            return  emptyMsg("图片");
        if(moreAttention.getStatus()==null)
            return  emptyMsg("状态");
        if(moreAttention.getOrderBy()==null)
            return  emptyMsg("排序位置");
        return  null;
    }

    /**
     * 修改验证
     * @param moreAttention
     * @return
     */
    public String updateMoreAttentionValid(MoreAttention moreAttention) {
        return saveMoreAttentionValid(moreAttention);
    }
}
