package com.example.util;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 响应信息主体
 *
 * @param
 * @author
 */
@Getter
@Setter
@Accessors(chain = true)
public class Rs<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;
    /**
     * 统一参数验证异常
     */
    public static final int VALID_EX_CODE = -9;
    public static final int OPERATION_EX_CODE = -10;

    /**
     * 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode]
     */
    @ApiModelProperty(value = "响应编码:0-请求处理成功")
    private int code;

    /**
     * 是否执行默认操作
     */
    @JsonIgnore
    private Boolean defExec = true;

    /**
     * 调用结果
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 结果消息，如果调用成功，消息通常为空T
     */
    @ApiModelProperty(value = "提示消息")
    private String msg = "ok";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;


    /**
     * 请求路径
     */
    @ApiModelProperty(value = "请求路径")
    @JsonIgnore
    private String path;
    /**
     * 附加数据
     */
    @ApiModelProperty(value = "附加数据")
    @JsonIgnore
    private Map<String, Object> extra;

    /**
     * 响应时间
     */
    @ApiModelProperty(value = "响应时间戳")
    private long timestamp = System.currentTimeMillis();

    private Rs() {
        super();
    }

    public Rs(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.defExec = false;
    }

    public Rs(RsCode rsCode, T data) {
        this.code = rsCode.code();
        this.data = data;
        this.msg = rsCode.msg();
        this.defExec = false;
    }

    public Rs(int code, T data, String msg, boolean defExec) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.defExec = defExec;
    }

    public static <E> Rs<E> result(int code, E data, String msg) {
        return new Rs<>(code, data, msg);
    }

    /**
     * 请求成功消息
     *
     * @param data 结果
     * @return RPC调用结果
     */
    public static <E> Rs<E> success(E data) {
        return new Rs<>(SUCCESS_CODE, data, "ok");
    }

    public static Rs<Boolean> success() {
        return new Rs<>(SUCCESS_CODE, true, "ok");
    }


    public static <E> Rs<E> successDef(E data) {
        return new Rs<>(SUCCESS_CODE, data, "ok", true);
    }

    public static <E> Rs<E> successDef() {
        return new Rs<>(SUCCESS_CODE, null, "ok", true);
    }

    public static <E> Rs<E> successDef(E data, String msg) {
        return new Rs<>(SUCCESS_CODE, data, msg, true);
    }

    /**
     * 请求成功方法 ，data返回值，msg提示信息
     *
     * @param data 结果
     * @param msg  消息
     * @return RPC调用结果
     */
    public static <E> Rs<E> success(E data, String msg) {
        return new Rs<>(SUCCESS_CODE, data, msg);
    }

    /**
     * 请求失败消息
     *
     * @param rsCode
     * @return
     */
    public static <E> Rs<E> fail(RsCode rsCode) {
        return new Rs<>(rsCode.code(), null, rsCode.msg());
    }

    public static <E> Rs<E> fail() {
        return new Rs<>(RsCode.ERROR.code(), null, RsCode.ERROR.msg());
    }


    public static <E> Rs<E> fail(int code, String msg) {
        return new Rs<>(code, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    public static <E> Rs<E> fail(String msg) {
        return fail(OPERATION_EX_CODE, msg);
    }

    public static <E> Rs<E> fail(String msg, Object... args) {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new Rs<>(OPERATION_EX_CODE, null, String.format(message, args));
    }


    /**
     * 请求失败消息，根据异常类型，获取不同的提供消息
     *
     * @param throwable 异常
     * @return RPC调用结果
     */
    public static <E> Rs<E> fail(Throwable throwable) {
        return fail(FAIL_CODE, throwable != null ? throwable.getMessage() : DEF_ERROR_MESSAGE);
    }

    public static <E> Rs<E> validFail(String msg) {
        return new Rs<>(VALID_EX_CODE, null, (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg);
    }

    public static <E> Rs<E> validFail(String msg, Object... args) {
        String message = (msg == null || msg.isEmpty()) ? DEF_ERROR_MESSAGE : msg;
        return new Rs<>(VALID_EX_CODE, null, String.format(message, args));
    }

    public static <E> Rs<E> timeout() {
        return fail(RsCode.TIMEOUT);
    }


    public Rs<T> put(String key, Object value) {
        if (this.extra == null) {
            this.extra = new HashMap<>(10);
        }
        this.extra.put(key, value);
        return this;
    }

    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    public Boolean getIsSuccess() {
        return this.code == SUCCESS_CODE || this.code == 200;
    }

    /**
     * 逻辑处理是否失败
     *
     * @return
     */
    public Boolean getIsError() {
        return !getIsSuccess();
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }


    public String getError() {
        return getIsError() ? getMsg() : null;
    }
}

