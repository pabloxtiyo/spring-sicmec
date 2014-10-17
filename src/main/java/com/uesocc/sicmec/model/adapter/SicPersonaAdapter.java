/**
 * 
 */
package com.uesocc.sicmec.model.adapter;

import com.uesocc.sicmec.framework.general.BaseAdapter;
import com.uesocc.sicmec.framework.general.SicDataTypeFormat;
import com.uesocc.sicmec.model.dto.SicPersonaDto;
import com.uesocc.sicmec.model.entity.SicPersona;

/**
 * @author xtiyo
 *
 */
public class SicPersonaAdapter implements
		BaseAdapter<SicPersona, SicPersonaDto> {

	@Override
	public SicPersona dtoToEntity(SicPersonaDto obj) 
	{
		// TODO Auto-generated method stub
		SicPersona entidad = new SicPersona();
		entidad.setIdSicPersona((obj.getIdSicPersona()!=null)?SicDataTypeFormat.toIntValue(obj.getIdSicPersona()):null);
		entidad.setNombre((obj.getNombre()!=null)?SicDataTypeFormat.toStringValue(obj.getNombre()):"");
		entidad.setApellido((obj.getApellido()!=null) ? SicDataTypeFormat.toStringValue(obj.getApellido()):"");
		entidad.setEmail((obj.getEmail()!=null) ? SicDataTypeFormat.toStringValue(obj.getEmail()) : "");
		
		return entidad;
	}

	@Override
	public SicPersonaDto entityToDto(SicPersona obj) 
	{
		// TODO Auto-generated method stub
		
		SicPersonaDto dto = new SicPersonaDto();
		dto.setIdSicPersona((obj.getIdSicPersona()!=null)?SicDataTypeFormat.toStringValue(obj.getIdSicPersona().toString()):"");
		dto.setNombre((obj.getNombre()!=null)?SicDataTypeFormat.toStringValue(obj.getNombre()):"");
		dto.setApellido((obj.getApellido()!=null) ? SicDataTypeFormat.toStringValue(obj.getApellido()):"");
		dto.setEmail((obj.getEmail()!=null) ? SicDataTypeFormat.toStringValue(obj.getEmail()) : "");
		
		return dto;
	}

}
