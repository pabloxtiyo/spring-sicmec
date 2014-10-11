/**
 * 
 */
package com.uesocc.sicmec.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesocc.sicmec.model.entity.SicPersona;
import com.uesocc.sicmec.model.repository.SicPersonaRepository;
import com.uesocc.sicmec.model.service.SicPersonaService;

/**
 * @author pablo portillo
 * @date 10/10/2014
 */
@Service
public class SicPersonaServiceImpl implements SicPersonaService {

	@Autowired
	private SicPersonaRepository sicPersonaRepository;
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
	public SicPersona insert(SicPersona entity) {
		// TODO Auto-generated method stub
		return sicPersonaRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.uesocc.sicmec.framework.general.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		if(sicPersonaRepository.exists(id))
		{
			sicPersonaRepository.delete(id);
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
	public SicPersona findById(Integer id) {
		// TODO Auto-generated method stub
		if(sicPersonaRepository.exists(id))
		{
			
			return sicPersonaRepository.findOne(id);
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
	public List<SicPersona> findAll() {
		// TODO Auto-generated method stub
		return sicPersonaRepository.findAll();
	}

}
