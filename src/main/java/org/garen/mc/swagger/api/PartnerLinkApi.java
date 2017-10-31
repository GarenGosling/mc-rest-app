/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;


import io.swagger.annotations.*;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.PartnerLink;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-13T02:54:43.490Z")

@Api(value = "partnerLink", description = "the partnerLink API")
public interface PartnerLinkApi {

    @ApiOperation(value = "删除合作链接", notes = "删除合作链接 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deletePartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "通过编码查询", notes = "通过编码查询 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink/code",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "合作链接编码") @RequestParam(value = "code", required = false) String code);


    @ApiOperation(value = "通过名称查询", notes = "通过名称查询 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink/name",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByName(@ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "分页查询合作链接", notes = "分页查询合作链接 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length, @ApiParam(value = "合作链接名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "通过状态查询", notes = "通过状态查询 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink/status",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatus(@Size(max = 1) @ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getPartnerLink(@ApiParam(value = "合作链接ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "新增合作链接", notes = "新增合作链接 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> savePartnerLink(@ApiParam(value = "合作链接") @Valid @RequestBody PartnerLink partnerLink);


    @ApiOperation(value = "修改合作链接", notes = "修改合作链接 ", response = ResponseModel.class, tags={ "partnerLink", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/partnerLink",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updatePartnerLink(@ApiParam(value = "合作链接") @Valid @RequestBody PartnerLink partnerLink);

}
