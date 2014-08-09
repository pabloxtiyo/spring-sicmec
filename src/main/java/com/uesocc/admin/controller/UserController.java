/**
 * 
 */
package com.uesocc.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.*;
import com.uesocc.admin.model.entity.User;
import com.uesocc.admin.model.serviceImpl.UserServiceImpl;

/**
 * @author pablo portillo
 * @date 31/7/2014
 */

@Controller
@RequestMapping("/users")
public class UserController 
{

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl UserServiceImpl;
	
	@RequestMapping("")
	public String defaultRequest(Model model)
	{
		model.addAttribute("hello", "Prueba uesocc");
		model.addAttribute("allUsers", UserServiceImpl.findAll());
		
		return "prueba";
		
	}
	
	@RequestMapping(value="/addNewUserPage")
	public String newUserRequestPage()
	{
		return "newUserForm";
	}
	
	@RequestMapping(value="/newUser",method=RequestMethod.POST)
	public String newUser(
			@RequestParam(value="name")String name,
			@RequestParam(value="lastname")String lastname
			)
			
	{
		logger.info("Creating new user..");
		
		User user = new User();
		
		user.setName(name);
		user.setLastname(lastname);
		UserServiceImpl.insert(user);
		
		logger.debug("redirect to the default page");
		
		return "redirect:/users";
	}
}
