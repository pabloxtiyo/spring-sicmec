/**
 * 
 */
package com.uesocc.admin.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uesocc.admin.model.entity.User;

/**
 * @author pablo portillo
 * @date 31/7/2014
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{

}
