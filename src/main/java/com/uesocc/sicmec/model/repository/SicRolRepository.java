/**
 * 
 */
package com.uesocc.sicmec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uesocc.sicmec.model.entity.SicRol;

/**
 * @author pablo portillo
 * @date 6/10/2014
 */
@Repository
public interface SicRolRepository extends JpaRepository<SicRol, Integer>{

}
