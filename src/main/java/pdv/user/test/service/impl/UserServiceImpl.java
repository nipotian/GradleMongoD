package pdv.user.test.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pdv.user.test.dao.UserDao;
import pdv.user.test.entity.User;
import pdv.user.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		User u=null;
		if(userDao.findByEmail(user.getEmail()).isEmpty()){
			u= userDao.save(user);
			u.setPassword("");
		}
		return u;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		List<User> ulist= userDao.findByEmail(email);
		User u=null;
		if(!ulist.isEmpty()){
			u=ulist.get(0);
		}
		return u;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> ulist= userDao.findAll();
		for(User u: ulist){
			u.setPassword("");			
		}
		return ulist;
	}

	@Override
	@Transactional
	public User update(User user) {
		// TODO Auto-generated method stub
		User u=userDao.findOne(user.getId());
		if(u!=null){
			u.setFirstName(user.getFirstName());
			u.setLastName(user.getLastName());
		}
		return u;
	}

}
