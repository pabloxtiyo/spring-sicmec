/**
 * 
 */
package com.uesocc.framework.general;

import java.io.Serializable;
import java.util.List;

/**
 * @author pablo portillo
 * @date 2/8/2014
 */

public interface BaseService<entity, ID extends Serializable> {
	
	public void setupService();

	/**
	 * @param entity
	 * @return The save entity
	 */
	public entity insert(entity entity);

	/**
	 * @param id
	 * @return true if the entity was delete and
	 * false if the entity wasn't delete
	 */
	public Boolean delete(ID id);

	/**
	 * @param id
	 * @return the entity find
	 */
	public entity findById(ID id);

	/**
	 * @return a list of entity's
	 */
	public List<entity> findAll();
}
