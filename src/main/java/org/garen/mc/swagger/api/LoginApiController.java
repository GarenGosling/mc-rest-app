package org.garen.mc.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;

import org.garen.mc.remote.LoginManage;
import org.garen.mc.remote.dto.CommonResponse;
import org.garen.mc.swagger.LoginDTO;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-10-19T15:43:37.058Z")

@Controller
public class LoginApiController extends BaseModel implements LoginApi {

    @Autowired
    LoginManage loginManage;

    @Override
    public ResponseEntity<ResponseModel> testLogin() {
        return new ResponseEntity<ResponseModel>(successModel("测试登录认证"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> getLoginVo(HttpServletRequest request, HttpServletResponse response) {
        CommonResponse commonResponse = loginManage.getLoginVoByRequest(request);
        if("200".equals(commonResponse.getCode())){
            return new ResponseEntity<ResponseModel>(successModel(commonResponse.getMessage(), commonResponse.getData()),HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel(commonResponse.getMessage()), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getLoginVo2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket) {
        CommonResponse commonResponse = loginManage.getLoginVoByTicket(ticket);
        if("200".equals(commonResponse.getCode())){
            return new ResponseEntity<ResponseModel>(successModel(commonResponse.getMessage(), commonResponse.getData()),HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel(commonResponse.getMessage()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseModel> isLogin(HttpServletRequest request, HttpServletResponse response) {
        LoginDTO loginDTO = loginManage.isLoginByRequest(request);
        if("200".equals(loginDTO.getCode())){
            return new ResponseEntity<ResponseModel>(successModel(loginDTO.getMessage()),HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel(loginDTO.getMessage()), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> isLogin2(@ApiParam(value = "登录凭证") @RequestParam(value = "ticket", required = false) String ticket) {
        LoginDTO loginDTO = loginManage.isLoginByTicket(ticket);
        if("200".equals(loginDTO.getCode())){
            return new ResponseEntity<ResponseModel>(successModel(loginDTO.getMessage()),HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(badRequestModel(loginDTO.getMessage()), HttpStatus.OK);
    }
}
