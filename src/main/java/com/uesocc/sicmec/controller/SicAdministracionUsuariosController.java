/**
 * 
 */
package com.uesocc.sicmec.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uesocc.sicmec.model.dto.SicPersonaDto;
import com.uesocc.sicmec.model.dto.SicUsuarioDto;
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
			RedirectAttributes redirectAttributes) throws ParseException
	{
		
		LOGGER.debug("Creando nuevo usuario");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SicPersonaDto persona = new SicPersonaDto();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setEmail(mail);
		
		SicUsuarioDto user = new SicUsuarioDto();
		user.setFxActivacion(simpleformat.format(new Date()));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 2);
		user.setFxDesactivacion(simpleformat.format(cal.getTime()));
		user.setCreadoPor("prueba");
		user.setModicadoPor("prueba");
		user.setFxCreado(format.format(new Date()));
		user.setFxModicado(format.format(new Date()));
		user.setSicPersona(sicPersonaServiceImpl.insert(persona));
		user.setSicRol(sicRolServiceImpl.findById(rol));
		
		LOGGER.info(user);
		sicUsuarioServiceImpl.insert(user);
		
		redirectAttributes.addFlashAttribute("success",true);
		
		return "redirect:/admin/usuarios";
	}
	
	@RequestMapping(value="/getUser/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SicUsuarioDto getUser(@PathVariable(value="id")int id)
	{
		return sicUsuarioServiceImpl.findById(id);
	}
}
