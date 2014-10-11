/**
 * 
 */
package com.uesocc.sicmec.controller;

import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.uesocc.sicmec.model.entity.SicPersona;
import com.uesocc.sicmec.model.entity.SicUsuario;
import com.uesocc.sicmec.model.serviceImpl.SicPersonaServiceImpl;
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
	Logger LOGGER = Logger.getLogger(SicAdministracionUsuariosController.class);
	
	@Autowired
	private SicUsuarioServiceImpl sicUsuarioServiceImpl;
	@Autowired
	private SicRolServiceImpl sicRolServiceImpl;
	@Autowired
	private SicPersonaServiceImpl sicPersonaServiceImpl;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String defaultRequest(Model model)
	{
		model.addAttribute("roles", sicRolServiceImpl.findAll());
		model.addAttribute("usuarios", sicUsuarioServiceImpl.findAll());
		
		return "/admin/administracionUsuarios";
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(
			@RequestParam(value="nombre")String nombre,
			@RequestParam(value="apellido")String apellido,
			@RequestParam(value="usuario")String usuario,
			@RequestParam(value="pass")String pass,
			@RequestParam(value="mail")String mail,
			@RequestParam(value="rol")int rol,
			RedirectAttributes redirectAttributes)
	{
		
		LOGGER.debug("Creando nuevo usuario");
		
		SicPersona persona = new SicPersona();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(mail);
		
		SicUsuario user = new SicUsuario();
		user.setFxActivacion(new Date());
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2);
		user.setFxDesactivacion(cal.getTime());
		user.setCreadoPor("prueba");
		user.setModicadoPor("prueba");
		user.setFxCreado(new Date());
		user.setFxModicado(new Date());
		user.setFkSicPersona(sicPersonaServiceImpl.insert(persona));
		user.setFkSicRol(sicRolServiceImpl.findById(rol));
		
		LOGGER.info(user);
		sicUsuarioServiceImpl.insert(user);
		
		redirectAttributes.addFlashAttribute("success",true);
		
		return "redirect:/admin/usuarios";
	}
}
