/**
 * 
 */
package com.uesocc.sicmec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pablo portillo
 * @date 5/10/2014
 */

@RequestMapping("/admin/usuarios")
@Controller
public class SicAdministracionUsuarios 
{
	@RequestMapping("")
	public String defaultRequest()
	{
		return "";
	}
}
