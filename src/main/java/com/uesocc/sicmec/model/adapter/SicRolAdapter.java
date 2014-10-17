/**
 * 
 */
package com.uesocc.sicmec.model.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.uesocc.sicmec.framework.general.BaseAdapter;
import com.uesocc.sicmec.framework.general.SicDataTypeFormat;
import com.uesocc.sicmec.model.dto.SicRolDto;
import com.uesocc.sicmec.model.entity.SicRol;

/**
 * @author xtiyo
 *
 */

public class SicRolAdapter implements BaseAdapter<SicRol, SicRolDto> {

	@Override
	public SicRol dtoToEntity(SicRolDto obj) throws ParseException 
	{
		// TODO Auto-generated method stub
		SicRol entidad = new SicRol();
		entidad.setIdSicRol((obj.getIdSicRol()!=null) ? SicDataTypeFormat.toIntValue(obj.getIdSicRol()):null);
		entidad.setNombreRol((obj.getNombreRol()!=null) ?  SicDataTypeFormat.toStringValue(obj.getNombreRol()):"");
		entidad.setDescripcionRol((obj.getDescripcionRol()!=null) ? SicDataTypeFormat.toStringValue(obj.getDescripcionRol()):"");
		entidad.setCreadoPor((obj.getCreadoPor()!=null) ? SicDataTypeFormat.toStringValue(obj.getCreadoPor()):"");
		entidad.setModicadoPor((obj.getModicadoPor()!=null)? SicDataTypeFormat.toStringValue(obj.getModicadoPor()):"");
		entidad.setFxCreado((obj.getFxCreado()!=null) ? SicDataTypeFormat.toDateTimeValue(obj.getFxCreado()):new Date());
		entidad.setFxModicado((obj.getFxModicado()!=null) ? SicDataTypeFormat.toDateTimeValue(obj.getFxModicado()):new Date());
		
		return entidad;
		
	}

	@Override
	public SicRolDto entityToDto(SicRol obj) 
	{
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SicRolDto dto = new SicRolDto();
		dto.setIdSicRol((obj.getIdSicRol()!=null) ? SicDataTypeFormat.toStringValue(obj.getIdSicRol().toString()):"");
		dto.setNombreRol((obj.getNombreRol()!=null) ?  SicDataTypeFormat.toStringValue(obj.getNombreRol()):"");
		dto.setDescripcionRol((obj.getDescripcionRol()!=null) ? SicDataTypeFormat.toStringValue(obj.getDescripcionRol()):"");
		dto.setCreadoPor((obj.getCreadoPor()!=null) ? SicDataTypeFormat.toStringValue(obj.getCreadoPor()):"");
		dto.setModicadoPor((obj.getModicadoPor()!=null)? SicDataTypeFormat.toStringValue(obj.getModicadoPor()):"");
		dto.setFxCreado((obj.getFxCreado()!=null) ? format.format(obj.getFxCreado()):format.format(new Date()));
		dto.setFxModicado((obj.getFxModicado()!=null) ? format.format(obj.getFxModicado()):format.format(new Date()));
		
		return dto;
	}

}
