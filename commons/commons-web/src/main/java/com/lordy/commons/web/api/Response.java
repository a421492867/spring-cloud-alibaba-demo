package com.lordy.commons.web.api;

public class Response {

    private Integer code;

    private String message;

    private Object data;

    private static Response error = new Response(500, "error", null);

    private static Response success = new Response(200, "success", null);

    public static Response error(){
        return error;
    }

    public static Response success(){
        return success;
    }

    public static Response dataSuccess(Object data){
        return new Response(200, "", data);
    }

    public Response(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
