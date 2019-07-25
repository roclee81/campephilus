package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import org.cqu.edu.msc.annihilation.campephilus.module.core.cache.CacheRemove;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BaseInfoSuperclass;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudUtils;
import org.cqu.edu.msc.annihilation.common.utils.TimeStampUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/14 18:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
public abstract class AbstractInfoService<T extends BaseInfoSuperclass, ID>  {

    public abstract JpaRepository<T, ID> getJpaRepository();

    protected abstract ID getId(T t);

    @CacheRemove()
    public synchronized void save(T t) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(getJpaRepository().findById(getId(t)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        ServiceCrudUtils.saveObjectAndCheckSuccess(getJpaRepository(), t);
    }

    @CacheRemove()
    public synchronized void update(T t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudUtils.updateObjectAndCheckSuccess(getJpaRepository(), getId(t), t);
    }

    @CacheRemove()
    public void delete(T t) {

    }

    @CacheRemove()
    public void delete(int id) {
        ServiceCrudUtils.deleteObjectAndCheckSuccess(getJpaRepository(), id);
    }

    public List<T> listAll(int page, int size) {
        Page<T> searchResult = getJpaRepository().findAll(PageRequest.of(page, size));
        return searchResult.getContent()
                .parallelStream()
                .filter(Objects::nonNull)
                .peek(t -> {
                    t.setLongCreate(TimeStampUtils.getTimestampOfDateTime(t.getGmtCreate()));
                    t.setLongModified(TimeStampUtils.getTimestampOfDateTime(t.getGmtModified()));
                })
                .collect(Collectors.toList())
                ;
    }


}
