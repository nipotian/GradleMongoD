package pdv.user.test.dao;

import java.util.List;

import pdv.user.test.entity.User;

public interface UserDao {

	public User save(User user);
	public User getUserByEmail(String email);
	public List<User> getUsers();
	
}
