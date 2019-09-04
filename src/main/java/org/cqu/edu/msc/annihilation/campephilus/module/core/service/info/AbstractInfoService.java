package org.cqu.edu.msc.annihilation.campephilus.module.core.service.info;

import lombok.extern.slf4j.Slf4j;
import org.cqu.edu.msc.annihilation.campephilus.module.core.domain.info.BaseInfoSuperclass;
import org.cqu.edu.msc.annihilation.campephilus.utils.CheckUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ConvertUtils;
import org.cqu.edu.msc.annihilation.campephilus.utils.ServiceCrudCheckUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Objects;

/**
 * @author lx
 * @version V1.0
 * @date 2019/6/14 18:51
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Slf4j
public abstract class AbstractInfoService<T extends BaseInfoSuperclass, ID> {

    public abstract JpaRepository<T, ID> getJpaRepository();

    protected abstract ID getId(T t);

//    @CacheRemove()
    public synchronized T save(T t) {
        // 首先查询是否存在该条数据
        // 判断到存在该仪器存在，则直接返回，抛出异常
        CheckUtils.checkDataIsExisted(getJpaRepository().findById(getId(t)).orElse(null));
        // 判断保存是否成功，不成功将抛出异常
        return ServiceCrudCheckUtils.saveObjectAndCheckSuccess(getJpaRepository(), t);
    }

//    @CacheRemove()
    public synchronized void update(T t) {
        // 更新字段，同时检查是否更新成功，不成功则抛出异常
        ServiceCrudCheckUtils.updateObjectAndCheckSuccess(getJpaRepository(), getId(t), t);
    }

    /**
     * 通过T中的数据查询数据库中完整的字段
     *
     * @param t 泛型
     * @return 数据库中完整的字段
     */
    public T getDataBaseEntity(T t) {
        return null;
    }

//    @CacheRemove()
    public void delete(T t) {
        // 判断t是否为null，同时查询t是否存在在数据库中，如果存在则删除
        if (Objects.nonNull(t) && Objects.nonNull(t = getDataBaseEntity(t))) {
            getJpaRepository().delete(t);
            // TODO 打印需不需要提取出来
            log.info("delete:{}", t.toString());
        }
    }

    public List<T> listById(Object id) {
        return null;
    }

    public List<T> listAll(int page, int size) {
        Page<T> searchResult = getJpaRepository().findAll(PageRequest.of(page, size));
        return ConvertUtils.convertObjectTimeStamp(searchResult.getContent());
    }

    public long countAll() {
        return getJpaRepository().count();
    }

}
