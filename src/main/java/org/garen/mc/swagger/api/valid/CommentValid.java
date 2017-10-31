package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.Comment;
import org.springframework.stereotype.Component;

/**
 * 评论参数验证类
 *
 * @author yanglimou
 * @create 2017/10/31 10:37
 * @since v1.0
 */
@Component
public class CommentValid extends BaseValid {
    /**
     * 保存验证
     * @param comment
     * @return
     */
    public String savePartnerLinkValid(Comment comment) {
        if(comment==null)
            return paramNullMsg();
        if(StringUtils.isBlank(comment.getArticleCode()))
            return  emptyMsg("文章编码");
        if(StringUtils.isBlank(comment.getContent()))
            return  emptyMsg("评论内容");
        return  null;
    }
}
