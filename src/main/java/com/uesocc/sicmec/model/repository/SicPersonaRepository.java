/**
 * 
 */
package com.uesocc.sicmec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uesocc.sicmec.model.entity.SicPersona;

/**
 * @author pablo portillo
 * @date 10/10/2014
 */
@Repository
public interface SicPersonaRepository extends JpaRepository<SicPersona, Integer> {

}
