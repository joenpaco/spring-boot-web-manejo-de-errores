package com.joenpaco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.joenpaco.models.dtos.UsuarioDto;
import com.joenpaco.services.UsuarioDtoService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioDtoService usuarioDtoService;
	
	@SuppressWarnings("unused")
	@GetMapping(value = {"/index"})
	public String index() {
		
//		Integer valor = 100/0;
		
		Integer valor = Integer.parseInt("10x");
		
		return "index";
		
	}
	
	@GetMapping(value = {"/ver/{id}"})
	public String ver(@PathVariable Integer id, Model model) {
		
		UsuarioDto usuarioDto = usuarioDtoService.findById(id);
		
		model.addAttribute("usuarioDto", usuarioDto);
		
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuarioDto.getNombre()));
		
		return "ver";
		
	}

}
