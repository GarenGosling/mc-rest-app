package org.garen.mc.remote;

import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.lang3.StringUtils;
import org.garen.mc.remote.dto.CommonResponse;
import org.garen.mc.remote.dto.LoginVo;
import org.garen.mc.swagger.LoginDTO;
import org.garen.mc.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginManage {

    @Autowired
    RestTemplateUtil restTemplateUtil;

    public CommonResponse getLoginVoByRequest(HttpServletRequest request){
        if(request == null){
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setCode("400");
            commonResponse.setMessage("获取登录信息失败，request为空");
            commonResponse.setData(null);
            return commonResponse;
        }
        String ticket = request.getHeader("ticket");
        return getLoginVoByTicket(ticket);
    }

    public CommonResponse getLoginVoByTicket(String ticket){
        if(StringUtils.isBlank(ticket)){
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setCode("400");
            commonResponse.setMessage("获取登录信息失败，登录凭证为空");
            commonResponse.setData(null);
            return commonResponse;
        }
        String url = "http://120.27.22.41:9090/loginVo2?ticket="+ticket;
        String loginVoJson = restTemplateUtil.get(url, String.class, new HashMap<>());
        CommonResponse commonResponse = new JsonMapper().fromJson(loginVoJson, CommonResponse.class);
        return commonResponse;
    }

    public LoginDTO isLoginByRequest(HttpServletRequest request){
        if(request == null){
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setCode("500");
            loginDTO.setMessage("request is null");
            return loginDTO;
        }
        String ticket = request.getHeader("ticket");
        return isLoginByTicket(ticket);
    }

    public LoginDTO isLoginByTicket(String ticket){
        if(StringUtils.isBlank(ticket)){
            LoginDTO loginDTO = new LoginDTO();
            loginDTO.setCode("400");
            loginDTO.setMessage("未登录");
            return loginDTO;
        }
        String url = "http://120.27.22.41:9090/isLogin";
        org.springframework.util.MultiValueMap<String, Object> param = new LinkedMultiValueMap();
        param.add("ticket", ticket);
        return restTemplateUtil.post(url, param, LoginDTO.class);
    }


}
