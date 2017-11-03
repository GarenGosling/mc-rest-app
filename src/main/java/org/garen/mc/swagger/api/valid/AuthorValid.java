package org.garen.mc.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.AuthorManage;
import org.garen.mc.swagger.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 作者验证类
 *
 * @author yanglimou
 * @create 2017/10/17 17:42
 * @since v1.0
 */
@Component
public class AuthorValid extends BaseValid {
    @Autowired
    private AuthorManage authorManage;
    /**
     * 保存验证
     * @param author
     * @return
     */
    public String saveMenuValid(Author author) {
        if(author==null)
            return paramNullMsg();
        if(StringUtils.isBlank(author.getUserCode()))
            return  emptyMsg("用户编码");
        if(StringUtils.isBlank(author.getPhone()))
            return  emptyMsg("手机号");
        if(StringUtils.isBlank(author.getIdNum()))
            return  emptyMsg("身份证号");
        if(StringUtils.isBlank(author.getRealName()))
            return  emptyMsg("真实姓名");
        if(StringUtils.isBlank(author.getPenName()))
            return  emptyMsg("笔名");
        if(author.getStatus()==null)
            return  emptyMsg("状态");
        //作者,手机号,身份证号重复验证
        if(authorManage.getByUserCode(author.getUserCode())!=null)
            return  "该用户已绑定作者";
        if(authorManage.getByPhone(author.getPhone())!=null)
            return  "该手机号已绑定作者";
        if(authorManage.getByIdNum(author.getIdNum())!=null)
            return  "该身份证号已绑定作者";
        return  null;
    }
    /**
     * 修改验证
     * @param author
     * @return
     */
    public String updateAuthorValid(Author author) {
        if(author==null)
            return paramNullMsg();
        if(author.getId()==null)
            return emptyMsg("id");
        if(StringUtils.isBlank(author.getUserCode()))
            return  emptyMsg("用户编码");
        if(StringUtils.isBlank(author.getPhone()))
            return  emptyMsg("手机号");
        if(StringUtils.isBlank(author.getIdNum()))
            return  emptyMsg("身份证号");
        if(StringUtils.isBlank(author.getRealName()))
            return  emptyMsg("真实姓名");
        if(StringUtils.isBlank(author.getPenName()))
            return  emptyMsg("笔名");
        if(author.getStatus()==null)
            return  emptyMsg("状态");
        //作者,手机号,身份证号重复验证
        org.garen.mc.mybatis.domain.Author author1=authorManage.getByUserCode(author.getUserCode());
        if(author1!=null&&author1.getId()!=author.getId())
            return  "该用户已绑定其他作者";
        author1=authorManage.getByPhone(author.getPhone());
        if(author1!=null&&author1.getId()!=author.getId())
            return  "该手机号已绑定其他作者";
        author1=authorManage.getByIdNum(author.getIdNum());
        if(author1!=null&&author1.getId()!=author.getId())
            return  "该身份证号已绑定其他作者";
        return  null;
    }

    /**
     * 笔名查询，参数验证
     * @param penName
     * @return
     */
    public String penNameValid(String penName) {
        if(StringUtils.isBlank(penName))
            return emptyMsg("penName");
        return null;
    }
    /**
     * 用户编码查询，参数验证
     * @param userCode
     * @return
     */
    public String userCodeValid(String userCode) {
        if(StringUtils.isBlank(userCode))
            return emptyMsg("userCode");
        return null;
    }


}
