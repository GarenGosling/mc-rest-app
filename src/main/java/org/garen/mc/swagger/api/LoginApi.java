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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-17T09:09:21.807Z")

@Api(value = "author", description = "the author API")
public interface LoginApi {

    @ApiOperation(value = "登录认证测试", notes = "登录认证测试", response = ResponseModel.class, tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    @RequestMapping(value = "/login/test",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> testLogin();

    @ApiOperation(value = "获取登录信息", notes = "获取登录信息", response = ResponseModel.class, tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    @RequestMapping(value = "/login/loginVo",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginVo(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "获取登录信息", notes = "获取登录信息", response = ResponseModel.class, tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    @RequestMapping(value = "/login/loginVo2",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getLoginVo2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket);

    @ApiOperation(value = "是否已登录", notes = "是否已登录 ", response = ResponseModel.class, tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/login/isLogin",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> isLogin(HttpServletRequest request, HttpServletResponse response);

    @ApiOperation(value = "是否已登录", notes = "是否已登录 ", response = ResponseModel.class, tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/login/isLogin2",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> isLogin2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket);


}
