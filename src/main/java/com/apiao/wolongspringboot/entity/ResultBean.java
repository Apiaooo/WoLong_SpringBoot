package com.apiao.wolongspringboot.entity;

/**
 * 封装返回结果集
 */
public class ResultBean {
    private Integer status;// 状态码：200是正常调用 400是没有找到
    private String msg;// 返回消息：成功还是失败
    private Object data;// 返回的对象。有时候我们要返回一些数据就放在这个里，如果不需要返回数据则是null
    private Boolean result; // 接口调用的结果 true是成功。false是失败。
    private String token;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResultBean(Integer status, String msg, Object data, Boolean result ,String token) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.result = result;
        this.token = token;
    }

    /**
     * 对返回值的封装
     * @param status
     * @param msg
     * @param object
     * @param flag
     * @return
     */
    public static ResultBean result(int status, String msg, Object object, boolean flag, String token) {
        return new ResultBean(status, msg, object, flag, token);
    }
}
