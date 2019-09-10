package org.cqu.edu.msc.annihilation.campephilus.module.core.service.data.core;

import org.cqu.edu.msc.annihilation.campephilus.module.core.service.CrudService;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/1 23:11
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public abstract class AbstractDataService<T, ID> implements CrudService<T> {

    protected abstract JpaRepository<T, ID> getJpaRepository();

    protected abstract ID getId(T t);

    @Override
    public List<T> listAll(int page, int size) {
        return getJpaRepository().findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public T save(T t) {
        // 不需要查询数据是否存在，因为是医疗仪器数据，数据有可能会重复
        // 只需要通过保存时间来判断即可
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(getJpaRepository(), t);
    }

    @Override
    public List<T> listById(Object id) {
        return null;
    }

    @Override
    public void update(T t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(getJpaRepository(), getId(t), t);
    }

    @Override
    public void delete(T t) {

    }

    @Override
    public long countAll() {
        return getJpaRepository().count();
    }

}
