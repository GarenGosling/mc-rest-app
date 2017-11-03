package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.swagger.model.Article;
import org.garen.mc.swagger.model.ArticleDetail;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章查询验证类
 *
 * @author yanglimou
 * @create 2017/10/24 14:02
 * @since v1.0
 */
@Component
public class ArticleValid extends  BaseValid{
    /**
     * 保存文章参数验证
     * @param article
     * @return
     */
    public String saveArticleValid(Article article) {
        if(StringUtils.isBlank(article.getTitle()))
            return emptyMsg("文章标题");
        if(StringUtils.isBlank(article.getSummary()))
            return emptyMsg("文章内容简述");
        if(StringUtils.isBlank(article.getMenuFullCode()))
            return emptyMsg("文章文类");
        if(StringUtils.isBlank(article.getMenuFullName()))
            return emptyMsg("文章文类");
        if(StringUtils.isBlank(article.getMd5()))
            return emptyMsg("主题图片");
        List<ArticleDetail> articleDetails=article.getArticleDetails();
        if(articleDetails==null||articleDetails.isEmpty())
            return  emptyMsg("文章正文");
        //验证至少有一个不为空
        for(ArticleDetail articleDetail:articleDetails){
            if(StringUtils.isNotBlank(articleDetail.getMd5())||StringUtils.isNotBlank(articleDetail.getText())){
                return null;
            }
        }
        return  emptyMsg("文章正文");
    }

    /**
     * 修改参数验证
     * @param article
     * @return
     */
    public String updateArticleValid(Article article) {
        return saveArticleValid(article);
    }
}
