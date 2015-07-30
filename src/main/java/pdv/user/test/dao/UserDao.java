package pdv.user.test.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import pdv.user.test.entity.User;

public interface UserDao extends MongoRepository<User,Integer>{

	List<User> findByEmail(String email);
	
}
