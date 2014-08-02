/**
 * 
 */
package com.uesocc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pablo portillo
 * @date 31/7/2014
 */

@Controller
@RequestMapping("/prueba")
public class UserController {

	@RequestMapping("")
	public String defaultRequest(Model model)
	{
		model.addAttribute("hello", "Prueba de atributo");
		
		return "prueba";
		
	}
}
