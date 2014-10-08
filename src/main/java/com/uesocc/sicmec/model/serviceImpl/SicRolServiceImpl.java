/**
 * 
 */
package com.uesocc.sicmec.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public SicRol insert(SicRol entity) {
		// TODO Auto-generated method stub
		return sicRolRepository.save(entity);
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
	public SicRol findById(Integer id) {
		// TODO Auto-generated method stub
		if(sicRolRepository.exists(id))
		{
			return sicRolRepository.findOne(id);
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
	public List<SicRol> findAll() {
		// TODO Auto-generated method stub
		return sicRolRepository.findAll();
	}

}
