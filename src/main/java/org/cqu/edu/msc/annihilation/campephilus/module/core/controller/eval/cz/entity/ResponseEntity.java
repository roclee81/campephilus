package org.cqu.edu.msc.annihilation.campephilus.module.core.controller.eval.cz.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

/**
 * 服务端响应类
 * @author cz
 *
 * JsonSerialize 配置保证序列化json的时候,如果是null的对象,key也会消失
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
@Builder
public class ResponseEntity<T> implements Serializable {

    /**
     * 状态
     */
    @Getter
    private int status;

    /**
     * 信息
     */
    @Getter
    private String msg;

    /**
     * 数据
     */
    @Getter
    private T data;

    /**
     * 几个私有构造方法
     * @param status 状态
     */
    private ResponseEntity(int status){
        this.status = status;
    }

    private ResponseEntity(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ResponseEntity(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResponseEntity(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    /**
     * 是否成功
     *
     * 不显示在JSON中
     * @return 是否成功
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }


    /**
     * 返回一个status
     * @param <T> 泛型
     * @return 响应
     */
    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode());
    }


    /**
     * 返回正确响应消息
     * @param msg 消息
     * @param <T> 泛型
     * @return 响应
     */
    public static <T> ResponseEntity<T> success(String msg) {
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    /**
     * 返回一个status
     * @param <T> 泛型
     * @return 响应
     */
    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(), data);
    }


    /**
     * 返回响应
     * @param msg 消息类型
     * @param data 数据
     * @param <T> 数据泛型
     * @return 响应
     */
    public static <T> ResponseEntity<T> success(String msg, T data) {
        return new ResponseEntity<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }


    /**
     * 错误返回响应
     * @param <T> 泛型参数
     * @return 错误反应
     */
    public static <T> ResponseEntity<T> error() {
        return new ResponseEntity<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }


    public static <T> ResponseEntity<T> error(String errorMessage) {
        return new ResponseEntity<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }


    public static <T> ResponseEntity<T> error(int errorCode, String errorMessage) {
        return new ResponseEntity<T>(errorCode, errorMessage);
    }

}
