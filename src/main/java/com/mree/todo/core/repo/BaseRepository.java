
/* * * Project: mysql-spring-boot-todo * Date Created: 13 Ara 2018 * Created By: MREE */
package com.mree.todo.core.repo;

import org.springframework.data.repository.CrudRepository;

import com.mree.todo.core.common.model.BaseInfo;
import com.mree.todo.core.persist.BaseEntity;

/** * @author MREE * * */

public interface BaseRepository < E extends BaseEntity < I >, I extends BaseInfo > extends CrudRepository < E, Long > {

}
