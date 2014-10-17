/**
 * 
 */
package com.uesocc.sicmec.framework.general;

import java.text.ParseException;

/**
 * @author xtiyo
 *
 */

public interface BaseAdapter <T,DTO>
{
	
	public T dtoToEntity(DTO obj) throws ParseException;
	
	public DTO entityToDto(T obj);
	
}
