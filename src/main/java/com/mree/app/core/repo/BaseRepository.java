package com.mree.app.core.repo;

import com.mree.app.core.common.model.BaseInfo;
import com.mree.app.core.persist.BaseEntity;
import org.springframework.data.repository.CrudRepository;

/** * @author MREE * * */

public interface BaseRepository<E extends BaseEntity<I>, I extends BaseInfo> extends CrudRepository<E, Long> {

}
