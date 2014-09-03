/**
 * 
 */
package com.uesocc.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pablo portillo
 * @date 3/9/2014
 */

@Controller
@RequestMapping("")
public class generalController 
{
	
	@RequestMapping("/")
	public String defaultRequest()
	{
		return "dashboard";
	}
}
