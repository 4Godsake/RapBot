package com.rapdog.rapbot.bean.result;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultVO extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public ResultVO() {
        put("code",200);
        put("msg","执行成功");
    }

    public static ResultVO error() {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, "未知异常，请联系管理员");
    }

    public static ResultVO error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }
    public static ResultVO error(int code, String msg) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO ok(String msg) {
        ResultVO r = new ResultVO();
        r.put("msg", msg);
        return r;
    }

    public static ResultVO ok(Map<String, Object> map) {
        ResultVO r = new ResultVO();
        r.putAll(map);
        return r;
    }

    public static ResultVO ok1(Object data) {
        ResultVO r = new ResultVO();
        r.put("data", JSON.toJSON(data));
        return r;
    }

    public static<T> ResultVO pagedOK(List<T> data) {
        PageInfo<T> pageInfo = new PageInfo<>(data);
        PageResult pageResult = new PageResult(pageInfo);
        return ResultVO.ok1(pageResult);
    }

    public static ResultVO ok() {
        return new ResultVO();
    }

    @Override
    public ResultVO put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage(){
        return (String) this.get("msg");
    }

    public static ResultVO checkError(String code, String msg) {
        ResultVO r = new ResultVO();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultVO authError() {
        return authError("权限验证失败，请检查权限信息");
    }

    public static ResultVO authError(String msg) {
        return authError(HttpStatus.HTTP_UNAUTHORIZED,msg);
    }

    public static ResultVO authError(int code, String msg) {
        return error(code,msg);
    }

}