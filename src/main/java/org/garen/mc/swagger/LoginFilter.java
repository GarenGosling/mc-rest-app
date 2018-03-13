package org.garen.mc.swagger;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.remote.RestTemplateUtil;
import org.garen.mc.util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-24T01:49:38.472Z")

public class LoginFilter implements Filter {
	@Autowired
	RestTemplateUtil restTemplateUtil;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		res.setContentType("text/plain;charset=UTF-8");
		String method = req.getMethod();
		if(!"OPTIONS".equals(method)){
			String ticket = req.getHeader("ticket");
			if(StringUtils.isBlank(ticket)){
				LoginDTO loginDTO = new LoginDTO();
				loginDTO.setCode("400");
				loginDTO.setMessage("未登录");
				String jsonStr = new JsonMapper().toJson(loginDTO);
				res.getWriter().write(jsonStr);
			}else{
				MultiValueMap<String, Object> param = new LinkedMultiValueMap();
				param.add("ticket", ticket);
				LoginDTO loginDTO = restTemplateUtil.post("http://47.104.170.186:9090/isLogin", param, LoginDTO.class);
				if("200".equals(loginDTO.getCode())){
					chain.doFilter(request, response);
				}else{
					res.getWriter().write(new JsonMapper().toJson(loginDTO));
				}
			}
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}