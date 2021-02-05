package com.ds.result;

import lombok.Data;

@Data
public class Result<T> {

    /**
     * 返回状态码
     * {@link ResultCode}
     */
    public int code;

    /**
     * 返回消息
     * {@link ResultMessage}
     */
    public String message;

    /**
     * 返回数据
     */
    public T data;

    public Result() {
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 默认的成功返回
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(){
        return new Result<>(ResultCode.SUCCESS,ResultMessage.SUCCESS,null);
    }

    /**
     * 只带消息的成功返回
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String message){
        return new Result<>(ResultCode.SUCCESS,message,null);
    }

    /**
     * 只带数据的成功返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS,ResultMessage.SUCCESS,data);
    }

    /**
     * 带消息和数据的成功返回
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(String message, T data){
        return new Result<>(ResultCode.SUCCESS,message,data);
    }

    /**
     * 默认的失败返回
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(){
        return new Result<>(ResultCode.FAIL,ResultMessage.FAIL,null);
    }

    /**
     * 只带消息的失败返回
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String message){
        return new Result<>(ResultCode.FAIL,message,null);
    }


    /**
     * 只带数据的返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(T data){
        return new Result<>(ResultCode.FAIL,ResultMessage.FAIL,data);
    }

    /**
     * 带消息和数据的失败返回
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(String message, T data){
        return new Result<>(ResultCode.FAIL,message,data);
    }
}
