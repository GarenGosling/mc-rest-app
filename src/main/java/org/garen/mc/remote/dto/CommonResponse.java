package org.garen.mc.remote.dto;

public class CommonResponse {
    private String code;
    private String message;
    private LoginVo data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginVo getData() {
        return data;
    }

    public void setData(LoginVo data) {
        this.data = data;
    }
}
