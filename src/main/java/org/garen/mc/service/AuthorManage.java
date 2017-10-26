package org.garen.mc.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.mc.mybatis.domain.Author;
import org.garen.mc.mybatis.domain.AuthorExample;
import org.garen.mc.mybatis.service.AuthorService;
import org.garen.mc.remote.LoginManage;
import org.garen.mc.remote.dto.CommonResponse;
import org.garen.mc.remote.dto.LoginVo;
import org.garen.mc.util.CodeGenerateUtils;
import org.garen.mc.util.EsapiUtil;
import org.garen.mc.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者业务类
 *
 * @author yanglimou
 * @create 2017/10/17 17:41
 * @since v1.0
 */
@Service
public class AuthorManage extends BaseManage<Long> {

    @Autowired
    private AuthorService<Author, AuthorExample, Long> authorService;
    @Autowired
    private LoginManage loginManage;

    @Override
    public AuthorService<Author, AuthorExample, Long> getService() {
        return authorService;
    }

    /**
     * 保存
     *
     * @param author
     * @return
     */
    public int saveMenu(org.garen.mc.swagger.model.Author author) {
        //去掉无用或者不应该传递的参数
        author.setId(null);
        //类型转换
        Author author1 = tranfer(author);

        //保存
        author1.setCode(CodeGenerateUtils.getRandomCode());
        author1.setCreateTime(new Date());
        return create(author1);
    }

    /**
     * 实体类与参数类的转换工具
     *
     * @param author
     * @return
     */
    private Author tranfer(org.garen.mc.swagger.model.Author author) {
        Author author1 = new Author();
        TransferUtil.transfer(author1, author);
        return author1;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteAuthor(Long id) {
        //删除
        return removeById(id);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<org.garen.mc.mybatis.domain.Author> getAll() {

        //查询
        return getService().findAll();
    }

    /**
     * id查询
     *
     * @param id
     * @return
     */
    public Author getAuthor(Long id) {
        //查询
        return findById(id);
    }

    /**
     * 编码查询
     *
     * @param code
     * @return
     */
    public Author getByCode(String code) {
        //构造查询条件
        AuthorExample example = new AuthorExample();
        AuthorExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(EsapiUtil.sql(code));
        //查询
        return getService().findByOne(example);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param penName
     * @return
     */
    public Map getByPage(Integer start, Integer length, String penName) {
        //初始化参数
        if (start == null) start = 0;
        if (length == null) length = 10;
        //构造查询条件
        AuthorExample example = new AuthorExample();
        AuthorExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(penName))
            criteria.andPenNameLike("%" + EsapiUtil.sql(penName.trim()) + "%");
        example.setOrderByClause("id desc");
        //查询
        List<Author> partnerLinks = getService().findBy(new RowBounds(start, length), example);
        long count = getService().countByExample(example);
        //构造返回map
        Map map = new HashMap();
        map.put("list", partnerLinks);
        map.put("count", count);
        return map;
    }

    /**
     * 笔名查询
     *
     * @param penName
     * @return
     */
    public List<Author> getByPenName(String penName) {
        //构造查询条件
        AuthorExample example = new AuthorExample();
        AuthorExample.Criteria criteria = example.createCriteria();
        criteria.andPenNameLike("%" + EsapiUtil.sql(penName.trim()) + "%");
        //查询
        return getService().findBy(example);
    }

    /**
     * 状态查询
     *
     * @param status
     * @return
     */
    public List<Author> getByStatus(Integer status) {
        //构造查询条件
        AuthorExample example = new AuthorExample();
        AuthorExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        //查询
        return getService().findBy(example);
    }

    /**
     * 用户编码查询
     *
     * @param userCode
     * @return
     */
    public Author getByUserCode(String userCode) {
        //构造查询条件
        AuthorExample example = new AuthorExample();
        AuthorExample.Criteria criteria = example.createCriteria();
        criteria.andUserCodeEqualTo(EsapiUtil.sql(userCode));
        //查询
        return getService().findByOne(example);
    }

    /**
     * 修改
     *
     * @param author
     * @return
     */
    public int updateAuthor(org.garen.mc.swagger.model.Author author) {
        //类型转换
        Author author1 = tranfer(author);
        //修改
        return modify(author1);
    }
    /**
     *
     * 根据请求获取作者
     * 必须要先登录
     * @param request
     * @return
     */
    public Author getAuthor(HttpServletRequest request){
        try {
            CommonResponse response=loginManage.getLoginVoByRequest(request);
            LoginVo loginVo=(LoginVo)response.getData();
            return getByUserCode(loginVo.getLoginInfo().getUserCode());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return  null;
    }
}
