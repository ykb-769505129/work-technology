package com.example.util;

/**
 * 参考：https://gitee.com/zuihou111/zuihou-admin-cloud.git
 *
 * @author zuihou
 */
public interface BaseController<Entity> {


    Class<Entity> getEntityClass();

    SuperService<Entity> getBaseService();


    /**
     * 成功返回
     *
     * @param data 返回内容
     * @param <T>  返回类型
     * @return R
     */
    default  <T> Rs<T> success(T data) {
        return Rs.success(data);
    }

    /**
     * 失败返回
     *
     * @param msg 失败消息
     * @param <T> 返回类型
     * @return
     */
    default <T> Rs<T> fail(String msg) {
        return Rs.fail(msg);
    }
}
