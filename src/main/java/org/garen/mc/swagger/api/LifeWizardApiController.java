package org.garen.mc.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.LifeWizardManage;
import org.garen.mc.swagger.api.valid.LifeWizardValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.LifeWizard;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-23T09:34:36.321Z")

@Controller
public class LifeWizardApiController extends BaseModel implements LifeWizardApi {
    @Autowired
    private LifeWizardManage lifeWizardManage;
    @Autowired
    private LifeWizardValid lifeWizardValid;

    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteLifeWizard(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        //验证
        String msg=lifeWizardValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=lifeWizardManage.deleteLifeWizard(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> getAll() {
        //业务
        List<org.garen.mc.mybatis.domain.LifeWizard> lifeWizards=lifeWizardManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部",lifeWizards),HttpStatus.OK);
    }

    /**
     * 根据项目名查询
     * @param name
     * @return
     */
    public ResponseEntity<ResponseModel> getByName(@ApiParam(value = "项目名") @RequestParam(value = "name", required = false) String name) {
        //业务
        List<org.garen.mc.mybatis.domain.LifeWizard> lifeWizards=lifeWizardManage.getByName(name);
        return new ResponseEntity<ResponseModel>(successModel("项目名查询",lifeWizards),HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param description
     * @return
     */
    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "首页生活向导项目名") @RequestParam(value = "name", required = false) String name) {
        //业务
        Map map=lifeWizardManage.getByPage(start,length,name);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",map),HttpStatus.OK);
    }

    /**
     * 根据状态查询
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByStatus( @Size(max=1)@ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status) {
        //验证
        String msg=lifeWizardValid.statusValid(status);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.LifeWizard> lifeWizards=lifeWizardManage.getByStatus(status);
        return new ResponseEntity<ResponseModel>(successModel("状态查询",lifeWizards),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getLifeWizard(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id) {
        //验证
        String msg=lifeWizardValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.LifeWizard lifeWizard=lifeWizardManage.getById(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询",lifeWizard),HttpStatus.OK);
    }

    /**
     * 保存
     * @param lifeWizard
     * @return
     */
    public ResponseEntity<ResponseModel> saveLifeWizard(@ApiParam(value = "首页生活向导"  )  @Valid @RequestBody LifeWizard lifeWizard) {
        

        //验证新增对象参数
        String msg = lifeWizardValid.saveLifeWizardValid(lifeWizard);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=lifeWizardManage.saveLifeWizard(lifeWizard);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 修改
     * @param lifeWizard
     * @return
     */
    public ResponseEntity<ResponseModel> updateLifeWizard(@ApiParam(value = "首页生活向导"  )  @Valid @RequestBody LifeWizard lifeWizard) {
        //验证
        String msg = lifeWizardValid.updateLifeWizardValid(lifeWizard);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=lifeWizardManage.updateLifeWizard(lifeWizard);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

}
