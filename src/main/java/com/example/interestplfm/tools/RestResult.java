package com.example.interestplfm.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zxq
 * @Date 2023-03-28
 * @Description
 */
@Slf4j
public class RestResult<T> implements Serializable {

    private Integer code;

    private T body;

    private Map<String, Object> extension;

    public RestResult() {
        this.extension = new HashMap<>();
    }

    public static <T> RestResult<T> build(T body) {
        RestResult<T> result = new RestResult<>();
        result.setCode(200);
        result.setBody(body);
        return result;
    }

    public static <T> RestResult<T> buildFailure(Map<String, Object> extension) {
        RestResult<T> result = new RestResult<>();
        result.setCode(500);
        result.setBody(null);
        if (extension != null) {
            result.getExtension().putAll(extension);
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            log.error("打印错误信息：{}", json);
        } catch (Exception e) {
            log.error("打印错误信息失败：{}", e.getMessage());
        }
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public Map<String, Object> getExtension() {
        return extension;
    }

    public void setExtension(Map<String, Object> extension) {
        this.extension = extension;
    }
}
