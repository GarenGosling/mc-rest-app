/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;


import io.swagger.annotations.*;
import org.garen.mc.swagger.model.Author;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Size;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-17T09:09:21.807Z")

@Api(value = "author", description = "the author API")
public interface AuthorApi {

    @ApiOperation(value = "删除作者", notes = "删除作者 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteAuthor(@ApiParam(value = "作者ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAuthor(@ApiParam(value = "作者ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "通过编码查询", notes = "通过编码查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/code",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "编码") @RequestParam(value = "code", required = false) String code);


    @ApiOperation(value = "分页查询作者", notes = "分页查询作者 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length, @ApiParam(value = "作者笔名") @RequestParam(value = "penName", required = false) String penName);


    @ApiOperation(value = "通过笔名查询", notes = "通过笔名查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/penName",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPenName(@ApiParam(value = "笔名") @RequestParam(value = "penName", required = false) String penName);


    @ApiOperation(value = "通过状态查询", notes = "通过状态查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/status",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatus(@Size(max = 1) @ApiParam(value = "0禁用，1启用") @RequestParam(value = "status", required = false) Integer status);


    @ApiOperation(value = "通过用户编码查询", notes = "通过编码查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author/userCode",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByUserCode(@ApiParam(value = "用户编码") @RequestParam(value = "userCode", required = false) String userCode);


    @ApiOperation(value = "新增作者", notes = "新增作者 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveAuthor(@ApiParam(value = "作者") @Valid @RequestBody Author author);


    @ApiOperation(value = "修改作者", notes = "修改作者 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/author",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateAuthor(@ApiParam(value = "作者") @Valid @RequestBody Author author);

}
