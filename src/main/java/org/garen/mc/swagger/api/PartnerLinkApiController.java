package org.garen.mc.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.PartnerLinkManage;
import org.garen.mc.swagger.api.valid.PartnerLinkValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.PartnerLink;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-18T23:23:41.235Z")

@Controller
public class PartnerLinkApiController extends BaseModel implements PartnerLinkApi {
    @Autowired
    private PartnerLinkManage partnerLinkManager;
    @Autowired
    private PartnerLinkValid partnerLinkValid;

    /**
     * id删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deletePartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Integer id) {
        //id为空验证
        String msg =  partnerLinkValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=partnerLinkManager.deletePartnerLink(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> getAll() {
        //业务
        List<org.garen.mc.mybatis.domain.PartnerLink> all=partnerLinkManager.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all),HttpStatus.OK);
    }

    /**
     * 编码查询
     * @param code
     * @return
     */
    public ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "合作链接编码") @RequestParam(value = "code", required = false) String code) {
        //验证
        String msg=partnerLinkValid.codeValid(code);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.PartnerLink partnerLinks=partnerLinkManager.getByCode(code);
        return new ResponseEntity<ResponseModel>(successModel("编码查询",partnerLinks),HttpStatus.OK);
    }

    /**
     * 名字查询
     * @param name
     * @return
     */
    public ResponseEntity<ResponseModel> getByName(@ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name) {
        //验证
        String msg=partnerLinkValid.nameValid(name);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.PartnerLink> partnerLinks=partnerLinkManager.getByName(name);
        return new ResponseEntity<ResponseModel>(successModel("名字查询",partnerLinks),HttpStatus.OK);
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
        @ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name) {
        //业务
        Map page=partnerLinkManager.getByPage(start,length,name);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",page),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getPartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Integer id) {
        //id为空验证
        String msg =  partnerLinkValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.PartnerLink partnerLink=partnerLinkManager.getPartnerLink(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询",partnerLink),HttpStatus.OK);
    }

    /**
     * 保存
     * @param partnerLink
     * @return
     */
    public ResponseEntity<ResponseModel> savePartnerLink(@ApiParam(value = "合作链接"  )  @Valid @RequestBody PartnerLink partnerLink) {
        //验证新增对象参数
        String msg = partnerLinkValid.savePartnerLinkValid(partnerLink);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=partnerLinkManager.savePartnerLink(partnerLink);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 修改
     * @param partnerLink
     * @return
     */
    public ResponseEntity<ResponseModel> updatePartnerLink(@ApiParam(value = "合作链接"  )  @Valid @RequestBody PartnerLink partnerLink) {
        //验证
        String msg = partnerLinkValid.updatePartnerLinkValid(partnerLink);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=partnerLinkManager.updatePartnerLink(partnerLink);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 状态查询
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByStatus( @Size(max=1)@ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status) {
        //验证
        String msg=partnerLinkValid.statusValid(status);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.PartnerLink> partnerLink=partnerLinkManager.getByStatus(status);
        return new ResponseEntity<ResponseModel>(successModel("状态查询",partnerLink),HttpStatus.OK);
    }

}
