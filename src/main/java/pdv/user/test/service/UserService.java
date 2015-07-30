package pdv.user.test.service;

import java.util.List;

import pdv.user.test.entity.User;

public interface UserService {
	
	public User save(User user);
	public User getUserByEmail(String email);
	public List<User> getUsers();
	public User update(User user);

}
