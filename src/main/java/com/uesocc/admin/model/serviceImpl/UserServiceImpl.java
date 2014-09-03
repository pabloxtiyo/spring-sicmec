/**
 * 
 */
package com.uesocc.admin.model.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uesocc.admin.model.entity.User;
import com.uesocc.admin.model.repository.UserRepository;
import com.uesocc.admin.model.service.UserService;

/**
 * @author pablo portillo
 * @date 2/8/2014
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#setupService()
	 */
	 
	@Resource
	private UserRepository UserRepository;
	
	@Override
	public void setupService() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#insert(java.lang.Object)
	 */
	@Override
	public User insert(User entity) {
		// TODO Auto-generated method stub
		
		return UserRepository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.uesocc.framework.general.BaseService#delete(java.io.Serializable)
	 */
	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		if(UserRepository.exists(id))
		{
			UserRepository.delete(id);
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
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		
		if(UserRepository.exists(id))
		{
			return UserRepository.findOne(id);
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
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		List<User> users = UserRepository.findAll();
		
		return users;
	}

}
