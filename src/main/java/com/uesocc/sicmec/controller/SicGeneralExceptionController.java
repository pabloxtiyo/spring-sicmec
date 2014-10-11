/**
 * 
 */
package com.uesocc.sicmec.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pablo portillo
 * @date 11/10/2014
 */
@ControllerAdvice
public class SicGeneralExceptionController 
{
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleCustomException(Exception ex) {
 
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errCode", ex.getMessage());
		model.addObject("errMsg", ex.getStackTrace());
		ex.printStackTrace();
		return model;
 
	}
}
