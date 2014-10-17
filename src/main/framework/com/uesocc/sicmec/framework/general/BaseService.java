/**
 * 
 */
package com.uesocc.sicmec.framework.general;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

/**
 * @author pablo portillo
 * @date 2/8/2014
 */

public interface BaseService<DTO, ID extends Serializable> {
	
	public void setupService();

	/**
	 * @param entity
	 * @return The save entity
	 * @throws ParseException 
	 */
	public DTO insert(DTO entity) throws ParseException;

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
	public DTO findById(ID id);

	/**
	 * @return a list of entity's
	 */
	public List<DTO> findAll();

}
