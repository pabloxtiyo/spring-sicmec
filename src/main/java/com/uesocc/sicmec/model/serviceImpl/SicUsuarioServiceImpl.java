/**
 * 
 */
package com.uesocc.sicmec.model.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uesocc.sicmec.model.entity.SicUsuario;
import com.uesocc.sicmec.model.repository.SicUsuarioRepository;
import com.uesocc.sicmec.model.service.SicUsuarioService;

/**
 * @author pablo portillo
 * @date 5/10/2014
 */

@Service
public class SicUsuarioServiceImpl implements SicUsuarioService {

	@Autowired
	private SicUsuarioRepository sicUsuarioRepository;
	
	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#setupService()
	 */
	@Override
	public void setupService() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#insert(java.lang.Object)
	 */
	@Override
	public SicUsuario insert(SicUsuario entity) 
	{
		// TODO Auto-generated method stub
		return this.sicUsuarioRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public Boolean delete(Integer id) 
	{
		// TODO Auto-generated method stub
		if(sicUsuarioRepository.exists(id))
		{
			sicUsuarioRepository.delete(id);
			return true;
		}
		else
		{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#findById(java.io.Serializable)
	 */
	@Override
	public SicUsuario findById(Integer id) 
	{
		// TODO Auto-generated method stub
		if(sicUsuarioRepository.exists(id))
		{
			return sicUsuarioRepository.findOne(id);
		}
		else
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#findAll()
	 */
	@Override
	public List<SicUsuario> findAll() 
	{
		// TODO Auto-generated method stub
		return sicUsuarioRepository.findAll();
	}

}
