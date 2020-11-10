package com.lordy.commons.entity;

public class Response {

    private Integer code;

    private String message;

    private Object data;

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

    private static Response error = new Response(500,"error", null);

    private static Response opreationSuccess = new Response(200, "success", null);

    public Response(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response error(){
        return error;
    }

    public static Response operationSuccess(){
        return opreationSuccess;
    }

    public static Response dataSuccess(Object data){
        return new Response(200, "success", data);
    }


}
