package org.garen.mc.swagger.api;

import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.MenuManage;
import org.garen.mc.swagger.api.valid.MenuValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.Menu;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.*;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-11T00:51:34.246Z")

@Controller
public class MenuApiController extends BaseModel implements MenuApi {
    @Autowired
    private MenuManage menuManage;
    @Autowired
    private MenuValid menuValid;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteMenu(@ApiParam(value = "菜单ID") @RequestParam(value = "id", required = false) Integer id) {
        //id为空验证
        String msg = menuValid.idValid(id);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i = menuManage.deletePartnerLink(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i), HttpStatus.OK);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public ResponseEntity<ResponseModel> getAll() {
        //业务
        List<org.garen.mc.mybatis.domain.Menu> all = menuManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    /**
     * 编码查询
     *
     * @param code
     * @return
     */
    public ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "菜单编码") @RequestParam(value = "code", required = false) String code) {
        //验证
        String msg = menuValid.codeValid(code);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Menu menu = menuManage.getByCode(code);
        return new ResponseEntity<ResponseModel>(successModel("编码查询", menu), HttpStatus.OK);
    }

    /**
     * 级别查询
     *
     * @param level
     * @return
     */
    public ResponseEntity<ResponseModel> getByLevel(@Size(max = 1) @ApiParam(value = "暂时有三级菜单：1,2,3") @RequestParam(value = "level", required = false) Integer level) {
        //验证
        String msg = menuValid.levelValid(level);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Menu> menus = menuManage.getByLevel(level);
        return new ResponseEntity<ResponseModel>(successModel("级别查询", menus), HttpStatus.OK);
    }

    /**
     * 名字查询
     *
     * @param name
     * @return
     */
    public ResponseEntity<ResponseModel> getByName(@ApiParam(value = "菜单名称") @RequestParam(value = "name", required = false) String name) {
        //验证
        String msg = menuValid.nameValid(name);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Menu> menus = menuManage.getByName(name);
        return new ResponseEntity<ResponseModel>(successModel("名字查询", menus), HttpStatus.OK);
    }

    /**
     * 父级编码查询
     *
     * @param pCode
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByparentCode(@ApiParam(value = "父菜单编码") @RequestParam(value = "parentCode", required = false) String parentCode,
                                                         @Size(max = 2) @ApiParam(value = "0表示显示，1表示不显示") @RequestParam(value = "status", required = false) Integer status) {
        // 验证
        String msg = menuValid.parentCodeValid(parentCode);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Menu> menus = menuManage.getByPatentCode(parentCode, status);
        return new ResponseEntity<ResponseModel>(successModel("父菜单编码查询", menus), HttpStatus.OK);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param length
     * @param name
     * @return
     */
    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                   @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                                   @ApiParam(value = "菜单名称") @RequestParam(value = "name", required = false) String name) {
        //业务
        Map page = menuManage.getByPage(start, length, name);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    /**
     * id查询
     *
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getMenu(@ApiParam(value = "菜单ID") @RequestParam(value = "id", required = false) Integer id) {
        //id为空验证
        String msg = menuValid.idValid(id);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Menu menu = menuManage.getMenu(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询", menu), HttpStatus.OK);
    }

    /**
     * 保存
     *
     * @param menu
     * @return
     */
    public ResponseEntity<ResponseModel> saveMenu(@ApiParam(value = "菜单") @Valid @RequestBody Menu menu) {
        //验证新增对象参数
        String msg = menuValid.saveMenuValid(menu);
        if (StringUtils.isNotBlank(msg)) {
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i = menuManage.saveMenu(menu);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i), HttpStatus.OK);
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
    public ResponseEntity<ResponseModel> updateMenu(@ApiParam(value = "菜单") @Valid @RequestBody Menu menu) {
        //验证
        String msg = menuValid.updateMenuValid(menu);
        if (StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i = menuManage.updateMenu(menu);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i), HttpStatus.OK);
    }

}
