package org.garen.mc.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.AuthorManage;
import org.garen.mc.swagger.api.valid.AuthorValid;
import org.garen.mc.swagger.model.Author;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-17T09:09:21.807Z")

@Controller
public class AuthorApiController extends BaseModel implements AuthorApi {
    @Autowired
    private AuthorManage authorManage;
    @Autowired
    private AuthorValid authorValid;

    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteAuthor(@ApiParam(value = "作者ID") @RequestParam(value = "id", required = false) Long id) {
        //id为空验证
        String msg =  authorValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=authorManage.deleteAuthor(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> getAll() {
        //业务
        List<org.garen.mc.mybatis.domain.Author> all=authorManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getAuthor(@ApiParam(value = "作者ID") @RequestParam(value = "id", required = false) Long id) {
        //id为空验证
        String msg =  authorValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Author author=authorManage.getAuthor(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询",author),HttpStatus.OK);
    }

    /**
     * 编码查询
     * @param code
     * @return
     */
    public ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "编码") @RequestParam(value = "code", required = false) String code) {
        //验证
        String msg=authorValid.codeValid(code);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Author author=authorManage.getByCode(code);
        return new ResponseEntity<ResponseModel>(successModel("编码查询",author),HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param name
     * @return
     */

    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                   @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                   @ApiParam(value = "作者笔名") @RequestParam(value = "penName", required = false) String penName,
                                                   @ApiParam(value = "作者真实姓名") @RequestParam(value = "realName", required = false) String realName,
                                                   @ApiParam(value = "作者审核状态") @RequestParam(value = "status", required = false) Integer status) {
        //业务
        Map page=authorManage.getByPage(start,length,penName,realName,start);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",page),HttpStatus.OK);
    }

    /**
     * 笔名查询
     * @param penName
     * @return
     */
    public ResponseEntity<ResponseModel> getByPenName(@ApiParam(value = "笔名") @RequestParam(value = "penName", required = false) String penName) {
        //验证
        String msg=authorValid.penNameValid(penName);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Author> authors=authorManage.getByPenName(penName);
        return new ResponseEntity<ResponseModel>(successModel("名字查询",authors),HttpStatus.OK);
    }

    /**
     * 状态查询
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByStatus( @Size(max=1)@ApiParam(value = "0禁用，1启用") @RequestParam(value = "status", required = false) Integer status) {
        //验证
        String msg=authorValid.statusValid(status);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Author> authors=authorManage.getByStatus(status);
        return new ResponseEntity<ResponseModel>(successModel("状态查询",authors),HttpStatus.OK);
    }

    /**
     * 用户编码查询
     * @param userCode
     * @return
     */
    public ResponseEntity<ResponseModel> getByUserCode(@ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode) {
        //验证
        String msg=authorValid.userCodeValid(userCode);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Author author=authorManage.getByUserCode(userCode);
        return new ResponseEntity<ResponseModel>(successModel("编码查询",author),HttpStatus.OK);
    }

    /**
     * 保存
     * @param author
     * @return
     */
    public ResponseEntity<ResponseModel> saveAuthor(@ApiParam(value = "作者"  )  @Valid @RequestBody Author author) {
        //验证新增对象参数
        String msg = authorValid.saveMenuValid(author);
        if (StringUtils.isNotBlank(msg)) {
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i = authorManage.saveMenu(author);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i), HttpStatus.OK);
    }

    /**
     * 修改
     * @param author
     * @return
     */
    public ResponseEntity<ResponseModel> updateAuthor(@ApiParam(value = "作者"  )  @Valid @RequestBody Author author) {
        //验证
        String msg = authorValid.updateAuthorValid(author);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=authorManage.updateAuthor(author);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 审核作者
     * @param id
     * @param status
     * @param rejectReason
     * @return
     */
    public ResponseEntity<ResponseModel> auditAuthor(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id,
                                                     @ApiParam(value = "审核状态") @RequestParam(value = "status", required = false) Integer status,
                                                     @ApiParam(value = "驳回理由") @RequestParam(value = "rejectReason", required = false) String rejectReason) {
        String msg=authorValid.auditAuthorValid(status,rejectReason);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        int i=authorManage.auditAuthor(id,status,rejectReason);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }
}
