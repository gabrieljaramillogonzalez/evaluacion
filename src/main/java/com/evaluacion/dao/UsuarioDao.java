package com.evaluacion.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.evaluacion.model.Usuario;


public interface UsuarioDao extends CrudRepository<Usuario, Long>{
	Usuario findByIdUsuario(long idUsuario);
	
	@Query("select u from Usuario u where u.curp like :curp ")
	Usuario findByCurp(@Param("curp")  String curp);
	
}
