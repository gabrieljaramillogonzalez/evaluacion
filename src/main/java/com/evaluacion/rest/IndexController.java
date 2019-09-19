package com.evaluacion.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/evaluacion")
	public String getLogin() {
		return "evaluacion";
	}
}
