package com.joenpaco.services;

import java.util.List;

import com.joenpaco.models.dtos.UsuarioDto;

public interface UsuarioDtoService {
	
	public abstract List<UsuarioDto> usuarioList();
	
	public abstract UsuarioDto findById(Integer id);

}
