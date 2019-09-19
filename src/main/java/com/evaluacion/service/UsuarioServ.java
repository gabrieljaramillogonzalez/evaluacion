package com.evaluacion.service;

import java.util.List;

import com.evaluacion.model.Usuario;


public interface UsuarioServ {
	
	Usuario findById(long id);
	Usuario findByCurp(String curp);
	void updateUsuario(Usuario usuario);
	void delateUsuario(long id);
	List<Usuario> findAllUsuario();
	void saveUsuario(Usuario usuario);
	boolean isExistendUsuario(Usuario usuario);
	
}
