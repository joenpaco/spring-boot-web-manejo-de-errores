package com.joenpaco.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.joenpaco.errors.UsuarioNotFoundException;
import com.joenpaco.models.dtos.UsuarioDto;
import com.joenpaco.services.UsuarioDtoService;

@Service
public class UsuarioDtoServiceImpl implements UsuarioDtoService {

	private List<UsuarioDto> lista;

	public UsuarioDtoServiceImpl() {

		lista = Arrays.asList(
				new UsuarioDto(1, "Andrés", "Guzmán"),
				new UsuarioDto(2, "Pepa", "García"),
				new UsuarioDto(3, "Lalo", "Mena"),
				new UsuarioDto(4, "Luci", "Fernández"),
				new UsuarioDto(5, "Pato", "González"),
				new UsuarioDto(6, "Paco", "Rodríguez"),
				new UsuarioDto(7, "Juan", "Gómez"));

	}

	@Override
	public List<UsuarioDto> usuarioList() {
		return lista;
	}

	@SuppressWarnings("unused")
	@Override
	public UsuarioDto findById(Integer id) {

		UsuarioDto usuarioDto = null;

		List<UsuarioDto> usuarioList = lista.stream().filter(usuario -> usuario.getId().equals(id)).collect(Collectors.toList());

		if (!usuarioList.isEmpty()) {

			usuarioDto = usuarioList.get(0);

			return usuarioDto;

		}
		
		throw new UsuarioNotFoundException("Usuario con Id: " + id + " No Existe en el sistema");

	}

}
