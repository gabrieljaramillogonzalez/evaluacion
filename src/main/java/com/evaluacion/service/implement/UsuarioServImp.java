package com.evaluacion.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.dao.UsuarioDao;
import com.evaluacion.model.Usuario;
import com.evaluacion.service.UsuarioServ;

@Service
public class UsuarioServImp implements UsuarioServ{
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	private static List<Usuario> listaUsuario;
	
	
	public Usuario findById(long id) {
		return usuarioDao.findByIdUsuario(id);
	}

	public Usuario findByCurp(String curp){
		return usuarioDao.findByCurp(curp);
	}

	public void updateUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public void delateUsuario(long id) {
		usuarioDao.delete(usuarioDao.findByIdUsuario(id));
	}

	public List<Usuario> findAllUsuario() {
		List<Usuario> listaUsuariosAux = (List<Usuario>) usuarioDao.findAll();
		if(!listaUsuariosAux.isEmpty()) {
			listaUsuario = listaUsuariosAux;
		}else {
			listaUsuario = new ArrayList<Usuario>();
		}
		return listaUsuario;
	}

	public void saveUsuario(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public boolean isExistendUsuario(Usuario usuario) {
		Usuario usu  = usuarioDao.findByCurp(usuario.getCurp());
		return usu == null;
	}

}
