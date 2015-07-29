package pdv.user.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pdv.user.test.dao.UserDao;
import pdv.user.test.entity.User;

@Component
public class UserDaoImpl implements UserDao{

	private static List<User> userList=new ArrayList<User>();

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user=null;	
		for(User u:userList){
			if(u.getEmail().equals(email))
				user=u;
		}
		return user;
	}
	
}
