package org.cqu.edu.mrc.realdata.modules.app.repository;

import org.cqu.edu.mrc.realdata.modules.app.dataobject.PostoperativePatientDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * realdata
 *
 * @author lx
 * @version V1.0
 * @date 2018/12/19 20:46
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
@Repository
public interface PostoperativePatientRepository extends MongoRepository<PostoperativePatientDO, String> {
}
