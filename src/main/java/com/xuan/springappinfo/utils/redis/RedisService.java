package com.xuan.springappinfo.utils.redis;

import java.util.List;

public interface RedisService {

    /**
     * set存数据 （不设置expire存活时间）
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(final String key, String value);

    /**
     * 写入redis缓存（设置expire存活时间）
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    boolean set(final String key, String value, Long expire);

    /**
     * get获取数据
     *
     * @param key
     * @return
     */
    Object get(final String key);

    /**
     * 判断redis缓存中是否有对应的key
     *
     * @param key
     * @return
     */
    boolean exists(final String key);

    /**
     * 移除数据
     *
     * @param key
     * @return
     */
    boolean remove(final String key);

    /**
     * redis根据keys批量删除对应的value
     *
     * @param keys
     * @return
     */
    void remove(final String... keys);

    /**
     * 存放 类
     *
     * @return boolean
     * @Author YatXuan
     * @Description //TODO
     * @Date 14:42 2018/10/30 0030
     * @Param [key, value]
     **/
     boolean setClass(String key,  Object value);

    /**
     * 取出 类
     *
     * @return
     * @Author YatXuan
     * @Description //TODO
     * @Date 14:43 2018/10/30 0030
     * @Param
     **/
    <T> T getClazz(String key, Class<T> clazz);

    /**
     * 存放list集合
     *
     * @return boolean
     * @Author YatXuan
     * @Description //TODO
     * @Date 15:10 2018/10/30 0030
     * @Param [key, list]
     **/
    <T> boolean setList(String key, List<T> list);

    /**
     * 取出list集合
     *
     * @return java.util.List<java.lang.Object>
     * @Author YatXuan
     * @Description //TODO
     * @Date 15:10 2018/10/30 0030
     * @Param [key]
     **/
    <T> List<T> getList(String key);
}
