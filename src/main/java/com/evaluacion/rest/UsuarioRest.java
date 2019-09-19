package com.evaluacion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.evaluacion.model.Usuario;
import com.evaluacion.service.UsuarioServ;


@RestController 
public class UsuarioRest {
	
	@Autowired
	private UsuarioServ usuarioServ;
	
	@RequestMapping(value = "/usuarios" , method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listaAllUsariosAlumnos(){
		List<Usuario> usuarios = usuarioServ.findAllUsuario();
		
		if (usuarios.isEmpty()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Usuario> usario(@PathVariable("id") long id){
		Usuario usuario = usuarioServ.findById(id);
		
		if (usuario.getIdUsuario()== 0 ) {
			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/" , method = RequestMethod.POST)
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario , UriComponentsBuilder ucB){
		if(usuario.validaUsuario()) {
			if(usuarioServ.isExistendUsuario(usuario)) {
				usuarioServ.updateUsuario(usuario);
			}else {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_EXTENDED);
			}
		}else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}" , method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario ){		
		if(id != 0 && usuario.validaUsuario()) {
			if(!usuarioServ.isExistendUsuario(usuario)) {
				usuarioServ.updateUsuario(usuario);
			}else {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_EXTENDED);
			}
		}else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> delateUsuario(@PathVariable("id") long id){
		Usuario usuario= usuarioServ.findById(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuarioServ.delateUsuario(id);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
}
