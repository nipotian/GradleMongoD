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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public User addUser(@RequestParam String fn,
			@RequestParam String ln,
			@RequestParam String ml,
			@RequestParam String pw
			){
		User u= new User(fn,ln,ml,pw);
		return userService.save(u);
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public User getUser(@RequestParam String ml){
		User u=userService.getUserByEmail(ml);
		return u;
	}
	
	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public List<User> getList(){
		return userService.getUsers();
	}
}
