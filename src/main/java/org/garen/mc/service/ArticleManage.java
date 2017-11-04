package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.Article;
import org.garen.mc.mybatis.domain.ArticleDetail;
import org.garen.mc.mybatis.domain.ArticleExample;
import org.garen.mc.mybatis.domain.Author;
import org.garen.mc.mybatis.service.ArticleService;
import org.garen.mc.remote.LoginManage;
import org.garen.mc.remote.dto.LoginVo;
import org.garen.mc.swagger.model.Audit;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章业务类
 *
 * @author yanglimou
 * @create 2017/10/24 11:29
 * @since v1.0
 */
@Service
public class ArticleManage extends BaseManage<Long> {
    @Autowired
    private ArticleService<Article, ArticleExample, Long> articleService;

    @Override
    public ArticleService<Article, ArticleExample, Long> getService() {
        return articleService;
    }

    @Autowired
    private ArticleDetailManage articleDetailManage;

    @Autowired
    private LoginManage loginManage;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteCarousel(Long id) {
        return removeById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<Article> getAll() {
        return findAll();
    }

    /**
     * id查询
     *
     * @param id
     * @return
     */
    public Article getById(Long id) {
        Article article = findById(id);
        if (article != null) {
            viewArticle(article);
            List<ArticleDetail> articleDetails = articleDetailManage.findByArticleCode(article.getCode());
            article.setArticleDetails(articleDetails);
        }
        return article;
    }

    /**
     * 查看文章，查看数+1
     *
     * @param article
     */
    private void viewArticle(Article article) {
        article.setViewNum(article.getViewNum() + 1);
        modify(article);
    }

    /**
     * 保存文章
     *
     * @param article
     * @return
     */
    public int saveArticle(org.garen.mc.swagger.model.Article article,Author author) {
        //先将文章详情列表取出来
        List<org.garen.mc.swagger.model.ArticleDetail> articleDetails = article.getArticleDetails();
        article.setArticleDetails(null);
        //转换类
        Article article1 = tranfer(article);
        //生成code
        String code = CodeGenerateUtils.getRandomCode();
        article1.setCode(code);
        article1.setUserCode(author.getUserCode());
        article1.setAuthorCode(author.getCode());
        article1.setAuthorPenName(author.getPenName());
        int i = articleDetailManage.saveArticleDetails(articleDetails, code);
        return create(article1);
    }

    /**
     * 修改
     *
     * @param id
     * @param article
     * @return
     */
    public int updateArticle(Long id, org.garen.mc.swagger.model.Article article) {
        //先将文章详情列表取出来
        List<org.garen.mc.swagger.model.ArticleDetail> articleDetails = article.getArticleDetails();
        article.setArticleDetails(null);
        //转换类
        Article article1 = tranfer(article);

        //根据id获取数据库对象
        Article article2 = getById(id);
        String code = article2.getCode();
        //删除相关文章详情
        articleDetailManage.deleteByArticleCode(code);
        int i = articleDetailManage.saveArticleDetails(articleDetails, code);
        article1.setId(id);
        article1.setStatus(0);
        return modify(article1);
    }

    /**
     * 实体类与参数类的转换工具
     *
     * @param article
     * @return
     */
    private Article tranfer(org.garen.mc.swagger.model.Article article) {
        Article article1 = new Article();
        TransferUtil.transfer(article1, article);
        return article1;
    }

    /**
     * 统一查询方法
     *
     * @param title
     * @param menuCode
     * @param subjectName
     * @param showDetail
     * @param orderBy
     * @param start
     * @param length
     * @return
     */
    public Map findArticle(String title, String menuCode, String subjectName, Integer showDetail, String orderBy, Integer start, Integer length) {
        //初始化参数
        if (start == null) start = 0;
        if (length == null) length = 10;
        //构造查询条件
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        if (StringUtils.isNotBlank(title))
            criteria.andTitleLike("%" + EsapiUtil.sql(title.trim()) + "%");
        if (StringUtils.isNotBlank(menuCode))
            criteria.andMenuFullCodeLike("%" + EsapiUtil.sql(menuCode.trim()) + "%");
        if (StringUtils.isNotBlank(subjectName))
            criteria.andSubjectNameLike("%" + EsapiUtil.sql(subjectName.trim()) + "%");
        if (StringUtils.isNotBlank(orderBy))
            articleExample.setOrderByClause(EsapiUtil.sql(orderBy));
        //查询实体数据
        List<Article> articles = getService().findBy(new RowBounds(start, length), articleExample);
        if (showDetail != null && showDetail == 1) {
            //查询详情
            for (Article article : articles) {
                //文章查看数+1
                viewArticle(article);
                List<ArticleDetail> articleDetails = articleDetailManage.findByArticleCode(article.getCode());
                article.setArticleDetails(articleDetails);
            }
        }
        //查询统计个数
        String sql = "select count(*) count from article where 1=1 ";

        if (StringUtils.isNotBlank(title))
            sql += " AND title like '%" + EsapiUtil.sql(title.trim()) + "%'";
        if (StringUtils.isNotBlank(menuCode))
            sql += " AND menu_full_code like '%" + EsapiUtil.sql(menuCode.trim()) + "%'";
        if (StringUtils.isNotBlank(subjectName))
            sql += " AND subject_name like '%" + EsapiUtil.sql(subjectName.trim()) + "%'";
        //查询
        int count = getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", articles);
        map.put("count", count);
        return map;
    }

    /**
     * 精选会员查询
     * //先通过sql语句查询文章查看数最高的作者
     *
     * 然后根据作者找到点击数最高的文章
     *
     *
     * @param menuCode
     * @param start
     * @param length
     * @return
     */
    public Map findPopAuthor(String menuCode, Integer start, Integer length) {
        //初始化参数
        if (start == null) start = 0;
        if (length == null) length = 10;

        //查询作者码
        String sql="select author_code from article where 1=1";
        if(StringUtils.isNotBlank(menuCode))
            sql+=" and menu_full_code like '%"+EsapiUtil.sql(menuCode.trim())+"%'";
        sql+=" GROUP BY author_code ORDER BY sum(view_num) desc limit "+start+","+length;
        List<Map<String,String>> maps=getService().selectBySQL(sql);
        //根据作者码查询文章
        List<Article> articles=new ArrayList<>();
        for(Map<String,String> map:maps) {
            String authorCode = map.get("author_code");
            //根据作者码查询每一个作者在本栏目评论点击数最高的那个文章
            ArticleExample articleExample = new ArticleExample();
            ArticleExample.Criteria criteria = articleExample.createCriteria();
            if (StringUtils.isNotBlank(menuCode))
                criteria.andMenuFullCodeLike("%" + EsapiUtil.sql(menuCode.trim()) + "%");
            criteria.andAuthorCodeEqualTo(authorCode);
            articleExample.setOrderByClause("view_num desc");
            articleExample.setLimit(1);
            Article article = getService().findByOne(articleExample);
            articles.add(article);
        }
        //构造返回map
        Map map = new HashMap();
        map.put("list", articles);
        map.put("count", maps.size());
        return map;
    }

    /**
     * 文章查询
     * @param status
     * @return
     */
    public List<Article> findByStatus(Integer status) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andStatusEqualTo(status);
        return findListBy(articleExample);
    }

    /**
     * 审核
     * @param audit
     * @return
     */
    public int auditArticle(Audit audit) {
        Article article=new Article();
        article.setId(audit.getId());
        article.setStatus(audit.getStatus());
        article.setRejectReason(audit.getRemark());
        return modify(article);
    }

    /**
     * 按照用户查询
     * @param title
     * @param menuCode
     * @param subjectName
     * @param orderBy
     * @param start
     * @param length
     * @param authorName
     * @param status
     * @return
     */
    public Map findArticle2(String title, String menuCode, String subjectName, String orderBy, Integer start, Integer length, String authorName, Integer status, HttpServletRequest request) {
        LoginVo loginVo=loginManage.getLoginVo(request);
        if(loginVo==null)
            return null;
        //初始化参数
        if (start == null) start = 0;
        if (length == null) length = 10;
        //构造查询条件
        String sql= "select * from article a1 LEFT JOIN author a2 on a1.author_code=a2.`code` where 1=1";
        if (StringUtils.isNotBlank(title))
            sql += " AND a1.title like '%" + EsapiUtil.sql(title.trim()) + "%'";
        if (StringUtils.isNotBlank(menuCode))
            sql += " AND a1.menu_full_code like '%" + EsapiUtil.sql(menuCode.trim()) + "%'";
        if (StringUtils.isNotBlank(subjectName))
            sql += " AND a1.subject_name like '%" + EsapiUtil.sql(subjectName.trim()) + "%'";
        if(StringUtils.isNotBlank(authorName))
            sql+= " AND (a2.pen_name = '"+EsapiUtil.sql(authorName)+"' or a2.real_name='"+EsapiUtil.sql(authorName)+"')";
        if(status!=null)
            sql+=" AND a1.status="+status;
        //增加用户的查询限制
        //如果不是管理员的话，有用户限制
        if(!loginVo.getLoginInfo().getLoginName().equalsIgnoreCase("admin")){
            sql+=" AND a1.user_code='"+loginVo.getUserBase().getUserCode()+"'";
        }
        if(StringUtils.isNotBlank(orderBy))
            sql+=" order by "+EsapiUtil.sql(orderBy);
        sql+=" limit "+start+","+length;
        List<Map<String,Object>> list=getService().findBySQL(sql);


        //查询统计个数
        sql= "select count(*) from article a1 LEFT JOIN author a2 on a1.author_code=a2.`code` where 1=1";
        if (StringUtils.isNotBlank(title))
            sql += " AND a1.title like '%" + EsapiUtil.sql(title.trim()) + "%'";
        if (StringUtils.isNotBlank(menuCode))
            sql += " AND a1.menu_full_code like '%" + EsapiUtil.sql(menuCode.trim()) + "%'";
        if (StringUtils.isNotBlank(subjectName))
            sql += " AND a1.subject_name like '%" + EsapiUtil.sql(subjectName.trim()) + "%'";
        if(StringUtils.isNotBlank(authorName))
            sql+= " AND (a2.pen_name = '"+EsapiUtil.sql(authorName)+"' or a2.real_name='"+EsapiUtil.sql(authorName)+"')";
        if(status!=null)
            sql+=" AND a1.status="+status;
        if(!loginVo.getLoginInfo().getLoginName().equalsIgnoreCase("admin")){
            sql+=" AND a1.user_code='"+loginVo.getUserBase().getUserCode()+"'";
        }
        //查询
        int count = getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", list);
        map.put("count", count);
        return map;
    }
}
