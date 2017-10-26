package org.garen.mc.swagger.api;


import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.MoreAttentionManage;
import org.garen.mc.swagger.api.valid.MoreAttentionValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.MoreAttention;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T15:59:03.592Z")

@Controller
public class MoreAttentionsApiController extends BaseModel implements MoreAttentionsApi {
    @Autowired
    private MoreAttentionManage moreAttentionManage;
    @Autowired
    private MoreAttentionValid moreAttentionValid;
    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteMoreAttention(@ApiParam(value = "更多关注id",required=true ) @PathVariable("id") Long id) {
        //业务
        int i=moreAttentionManage.deleteMoreAttention(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> findALL() {
        //业务
        List<org.garen.mc.mybatis.domain.MoreAttention> all=moreAttentionManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all),HttpStatus.OK);
    }

    /**
     * 按状态查询
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByStatus(@ApiParam(value = "更多关注状态",required=true ) @PathVariable("status") Integer status) {
        //业务
        List<org.garen.mc.mybatis.domain.MoreAttention> moreAttention=moreAttentionManage.getByStatus(status);
        return new ResponseEntity<ResponseModel>(successModel("状态查询",moreAttention),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getMoreAttention(@ApiParam(value = "更多关注id",required=true ) @PathVariable("id") Long id) {
        //业务
        org.garen.mc.mybatis.domain.MoreAttention moreAttention=moreAttentionManage.getMoreAttention(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询",moreAttention),HttpStatus.OK);
    }

    /**
     * 保存
     * @param moreAttention
     * @return
     */
    public ResponseEntity<ResponseModel> saveMoreAttention(@ApiParam(value = "更多关注"  )  @Valid @RequestBody MoreAttention moreAttention) {
        //验证新增对象参数
        String msg = moreAttentionValid.saveMoreAttentionValid(moreAttention);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=moreAttentionManage.saveMoreAttention(moreAttention);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 修改
     * @param id
     * @param moreAttention
     * @return
     */
    public ResponseEntity<ResponseModel> updateMoreAttention(@ApiParam(value = "更多关注id",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "更多关注"  )  @Valid @RequestBody MoreAttention moreAttention) {
        //验证
        String msg = moreAttentionValid.updateMoreAttentionValid(moreAttention);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=moreAttentionManage.updateMoreAttention(moreAttention);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

}
