package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.mybatis.domain.ArticleDetail;
import org.garen.mc.mybatis.domain.ArticleDetailExample;
import org.garen.mc.mybatis.service.ArticleDetailService;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章详情业务类
 *
 * @author yanglimou
 * @create 2017/10/24 11:29
 * @since v1.0
 */
@Service
public class ArticleDetailManage extends BaseManage<Long> {
    @Autowired
    private ArticleDetailService articleDetailService;
    @Override
    public ArticleDetailService<ArticleDetail,ArticleDetailExample,Long> getService() {
        return articleDetailService;
    }

    /**
     * 按照文章编码删除
     * @param articleCode
     * @return
     */
    public int deleteByArticleCode(String articleCode){
        ArticleDetailExample articleDetailExample=new ArticleDetailExample();
        ArticleDetailExample.Criteria criteria=articleDetailExample.createCriteria();
        criteria.andArticleCodeEqualTo(articleCode);
        return getService().delete(articleDetailExample);
    }

    /**
     * 保存集合
     * @param articleDetails
     * @param articleCode
     * @return
     */
    public int saveArticleDetails(List<org.garen.mc.swagger.model.ArticleDetail> articleDetails,String articleCode){
        int i=0;
        for(org.garen.mc.swagger.model.ArticleDetail articleDetail:articleDetails){
            ArticleDetail articleDetail1=tranfer(articleDetail);
            if(StringUtils.isBlank(articleDetail1.getMd5())&&StringUtils.isBlank(articleDetail1.getText()))
                continue;
            articleDetail1.setArticleCode(articleCode);
            i+=articleDetailService.save(articleDetail1);
        }
        return i;
    }
    /**
     * 实体类与参数类的转换工具
     * @param articleDetail
     * @return
     */
    private ArticleDetail tranfer(org.garen.mc.swagger.model.ArticleDetail articleDetail) {
        ArticleDetail articleDetail1=new ArticleDetail();
        TransferUtil.transfer(articleDetail1,articleDetail);
        return  articleDetail1;
    }

    /**
     * 按照文章code查询
     * @param code
     * @return
     */
    public List<ArticleDetail> findByArticleCode(String code) {
        ArticleDetailExample example=new ArticleDetailExample();
        ArticleDetailExample.Criteria criteria=example.createCriteria();
        criteria.andArticleCodeEqualTo(code);
        return findListBy(example);
    }
}
