package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/18 20:34
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface CrudService<T> {

    /**
     * 保存
     *
     * @param t
     */
    void save(T t);

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * 列出所有的数据，根据分页信息
     *
     * @param page
     * @param size
     * @return
     */
    List<T> listAll(int page, int size);

    /**
     * 删除
     *
     * @param t
     */
    void delete(T t);

    long countAll();
}
