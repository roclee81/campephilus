package org.cqu.edu.msc.annihilation.campephilus.module.core.service;

import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.AfterOperationInfo;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/5/18 20:34
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public interface ServiceFactory<T> {
    void save(T t);

    void update(T t);

    List<T> listAll(int page, int size);

    void delete(T t);
}
