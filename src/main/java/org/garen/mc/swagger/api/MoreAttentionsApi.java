/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;


import io.swagger.annotations.*;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.MoreAttention;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-26T15:59:03.592Z")

@Api(value = "moreAttentions", description = "the moreAttentions API")
public interface MoreAttentionsApi {

    @ApiOperation(value = "id删除", notes = "根据更多关注id删除更多关注和更多关注详情 ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteMoreAttention(@ApiParam(value = "更多关注id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部更多关注 ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findALL();


    @ApiOperation(value = "状态查询", notes = "根据更多关注id查询更多关注和更多关注的详情 （首页接口设为1） ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions/status/{status}",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatus(@ApiParam(value = "更多关注状态", required = true) @PathVariable("status") Integer status);


    @ApiOperation(value = "id查询", notes = "根据更多关注id查询更多关注和更多关注的详情 ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions/{id}",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getMoreAttention(@ApiParam(value = "更多关注id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "新增更多关注", notes = "新增更多关注 ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveMoreAttention(@ApiParam(value = "更多关注") @Valid @RequestBody MoreAttention moreAttention);


    @ApiOperation(value = "修改更多关注", notes = "根据更多关注id修改更多关注 ", response = ResponseModel.class, tags={ "moreAttention", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/moreAttentions/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateMoreAttention(@ApiParam(value = "更多关注id", required = true) @PathVariable("id") Long id, @ApiParam(value = "更多关注") @Valid @RequestBody MoreAttention moreAttention);

}
