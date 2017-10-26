/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;


import io.swagger.annotations.*;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.Menu;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-13T03:01:05.745Z")

@Api(value = "menu", description = "the menu API")
public interface MenuApi {

    @ApiOperation(value = "删除菜单", notes = "删除菜单 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu",
            method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteMenu(@ApiParam(value = "菜单ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/all",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "通过编码查询", notes = "通过编码查询 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/code",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "菜单编码") @RequestParam(value = "code", required = false) String code);


    @ApiOperation(value = "通过菜单等级查询", notes = "通过菜单等级查询 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/level",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByLevel(@Size(max = 1) @ApiParam(value = "暂时有三级菜单：1,2,3") @RequestParam(value = "level", required = false) Integer level);


    @ApiOperation(value = "通过名称查询", notes = "通过名称查询 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/name",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByName(@ApiParam(value = "菜单名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "分页查询菜单", notes = "分页查询菜单 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/page",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length, @ApiParam(value = "菜单名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "通过父菜单编码查询", notes = "通过父菜单编码查询 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu/parentCode",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByparentCode(@ApiParam(value = "父菜单编码") @RequestParam(value = "parentCode", required = false) String parentCode, @Size(max = 2) @ApiParam(value = "0表示显示，1表示不显示") @RequestParam(value = "status", required = false) Integer status);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getMenu(@ApiParam(value = "菜单ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "新增菜单", notes = "新增菜单 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveMenu(@ApiParam(value = "菜单") @Valid @RequestBody Menu menu);


    @ApiOperation(value = "修改菜单", notes = "修改菜单 ", response = ResponseModel.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class)})

    @RequestMapping(value = "/menu",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateMenu(@ApiParam(value = "菜单") @Valid @RequestBody Menu menu);


    @ApiOperation(value = "通过父菜单编码查询，返回Tree格式", notes = "通过父菜单编码查询，返回Tree格式 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/menu/tree/parentCode",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getTreeByParentCode(@ApiParam(value = "父菜单编码") @RequestParam(value = "parentCode", required = false) String parentCode);


    @ApiOperation(value = "通过状态查询", notes = "通过状态查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/menu/status",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatus(@ApiParam(value = "状态（0，不显示，1，显示，2，显示热门）") @RequestParam(value = "status", required = false) Integer status);


}
