/**
 * 
 */
package com.uesocc.sicmec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uesocc.sicmec.model.entity.SicRol;
import com.uesocc.sicmec.model.serviceImpl.SicRolServiceImpl;
import com.uesocc.sicmec.model.serviceImpl.SicUsuarioServiceImpl;

/**
 * @author pablo portillo
 * @date 5/10/2014
 */

@RequestMapping("/admin/usuarios")
@Controller
public class SicAdministracionUsuariosController 
{
	
	@Autowired
	private SicUsuarioServiceImpl sicUsuarioServiceImpl;
	@Autowired
	private SicRolServiceImpl sicRolServiceImpl;
	
	@RequestMapping("")
	public String defaultRequest(Model model)
	{
		model.addAttribute("roles", sicRolServiceImpl.findAll());
		model.addAttribute("usuarios", sicUsuarioServiceImpl.findAll());
		
		return "/admin/administracionUsuarios";
	}
}
