package pdv.user.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if(userDao.getUserByEmail(user.getEmail())==null){
			u= userDao.save(user);
			u.setPassword("");
		}
		return u;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> ulist= userDao.getUsers();
		List<User> userList= new ArrayList<User>();
		for(User u: ulist){
			u.setPassword("");
			userList.add(u);
		}
		return userList;
	}

}
