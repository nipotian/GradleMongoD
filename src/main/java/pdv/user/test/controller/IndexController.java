package pdv.user.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pdv.user.test.entity.User;
import pdv.user.test.service.UserService;

@RestController
public class IndexController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(){
		return "index";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User addUser(@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam String email,
			@RequestParam String password
			){
		User u= new User(firstname,lastname,email,password);
		return userService.save(u);
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public User getUser(@RequestParam String email){
		User u=userService.getUserByEmail(email);
		return u;
	}
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public List<User> getList(){
		return userService.getUsers();
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User updateUser(@RequestParam Integer id,
			@RequestParam String firstname,
			@RequestParam String lastname
			){
		User u= new User(firstname,lastname,null,null);
		u.setId(id);
		return userService.update(u);
	}
	
}
