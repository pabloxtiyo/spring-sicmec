/**
 * 
 */
package com.uesocc.sicmec.model.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesocc.sicmec.model.adapter.SicRolAdapter;
import com.uesocc.sicmec.model.dto.SicRolDto;
import com.uesocc.sicmec.model.entity.SicRol;
import com.uesocc.sicmec.model.repository.SicRolRepository;
import com.uesocc.sicmec.model.service.SicRolService;

/**
 * @author pablo portillo
 * @date 6/10/2014
 */

@Service
public class SicRolServiceImpl implements SicRolService {

	@Autowired
	private SicRolRepository sicRolRepository;
	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#setupService()
	 */
	@Override
	public void setupService() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#insert(java.lang.Object)
	 */
	@Override
	public SicRolDto insert(SicRolDto entity) throws ParseException 
	{
		// TODO Auto-generated method stub
		SicRolAdapter adp = new SicRolAdapter();
		SicRol obj = adp.dtoToEntity(entity);
		return adp.entityToDto(sicRolRepository.save(obj));
	}

	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		if(sicRolRepository.exists(id))
		{
			sicRolRepository.delete(id);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#findById(java.io.Serializable)
	 */
	@Override
	public SicRolDto findById(Integer id) {
		// TODO Auto-generated method stub
		SicRolAdapter adp = new SicRolAdapter();
		
		if(sicRolRepository.exists(id))
		{
			return adp.entityToDto(sicRolRepository.findOne(id));
		}
		else
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#findAll()
	 */
	@Override
	public List<SicRolDto> findAll() {
		// TODO Auto-generated method stub
		SicRolAdapter adp = new SicRolAdapter();
		List<SicRol> list = sicRolRepository.findAll();
		List<SicRolDto> list_dto = new ArrayList<SicRolDto>();
		
		for (SicRol sicRol : list) 
		{
			list_dto.add(adp.entityToDto(sicRol));
		}
		
		return list_dto;
	}

}
