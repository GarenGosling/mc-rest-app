package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.*;
import org.garen.mc.mybatis.domain.Comment;
import org.garen.mc.mybatis.service.CommentService;
import org.garen.mc.mybatis.service.CommonsService;
import org.garen.mc.remote.LoginManage;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评论业务类
 *
 * @author yanglimou
 * @create 2017/10/31 9:16
 * @since v1.0
 */
@Service
public class CommentManage extends BaseManage<Long> {
    @Autowired
    private CommentService<Comment,CommentExample,Long> commentService;
    @Override
    public CommentService<Comment,CommentExample,Long> getService() {
        return commentService;
    }
    @Autowired
    private LoginManage loginManage;
    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteComment(Long id) {
        return removeById(id);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param articleCode
     * @return
     */
    public Map getByPage(Integer start, Integer length, String articleCode) {
        //初始化参数
        if(start==null) start=0;
        if(length==null) length=10;
        //构造查询条件
        CommentExample example=new CommentExample();
        CommentExample.Criteria criteria=example.createCriteria();
        if(StringUtils.isNotBlank(articleCode))
            criteria.andArticleCodeEqualTo( EsapiUtil.sql(articleCode.trim()));
        //查询主评论
        example.setOrderByClause("id desc");
        List<Comment> comments=getService().findBy(new RowBounds(start,length),example);
        //查询回复评论
        for(Comment comment:comments){
            //根据parentCode查询
            comment.setChildren(findByParentCode(comment.getCode()));
        }
        //构造查询sql
        String sql = "select count(*) count from comment where 1=1 ";
        if(StringUtils.isNotBlank(articleCode)){
            sql += " AND article_code ='"+ EsapiUtil.sql(articleCode)+"'" ;
        }
        //查询
        int count=getService().countBySQL(sql);
        //构造返回map
        Map map = new HashMap();
        map.put("list", comments);
        map.put("count", count);
        return map;
    }

    private List<Comment> findByParentCode(String parentCode){
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andParentCodeEqualTo(parentCode);
        commentExample.setOrderByClause("id desc");
        return findListBy(commentExample);
    }

    /**
     * 保存
     * @param comment
     * @return
     */
    public int saveComment(org.garen.mc.swagger.model.Comment comment, HttpServletRequest request) {
        Comment comment1=tranfer(comment);
        comment1.setCode(CodeGenerateUtils.getRandomCode());
        comment1.setLoginName(loginManage.getLoginName(request));
        return create(comment1);
    }

    /**
     * 实体类与参数类的转换工具
     * @param comment
     * @return
     */
    private Comment tranfer(org.garen.mc.swagger.model.Comment comment) {
        Comment comment1=new org.garen.mc.mybatis.domain.Comment();
        TransferUtil.transfer(comment1,comment);
        return  comment1;
    }
}
