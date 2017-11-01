/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;

import io.swagger.annotations.*;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.LifeWizard;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-23T09:34:36.321Z")

@Api(value = "lifeWizard", description = "the lifeWizard API")
public interface LifeWizardApi {

    @ApiOperation(value = "删除首页生活向导", notes = "删除首页生活向导 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteLifeWizard(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "通过项目名查询", notes = "状态和位置查询 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard/name",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByName(@ApiParam(value = "项目名") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "分页查询首页生活向导", notes = "分页查询首页生活向导 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length, @ApiParam(value = "首页生活向导项目名") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "通过状态查询", notes = "状态和位置查询 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard/status",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatus(@Size(max = 1) @ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLifeWizard(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "新增首页生活向导", notes = "新增首页生活向导 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveLifeWizard(@ApiParam(value = "首页生活向导") @Valid @RequestBody LifeWizard lifeWizard);


    @ApiOperation(value = "修改首页生活向导", notes = "修改首页生活向导 ", response = ResponseModel.class, tags={ "lifeWizard", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/lifeWizard",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateLifeWizard(@ApiParam(value = "首页生活向导") @Valid @RequestBody LifeWizard lifeWizard);

}