package com.evaluacion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;
	private String nombres;
	private String apellidos;
	private String estudioSup;
	private long edad;
	private String domicilio;
	private String curp;
	
	public Usuario() {
		this.idUsuario = 0 ;
	}
	
	public Usuario(long idUsuario, String nombres, String apellidos, String estudioSup, long edad, String domicilio,String curp) {
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.estudioSup = estudioSup;
		this.edad = edad;
		this.domicilio = domicilio;
		this.curp = curp;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEstudioSup() {
		return estudioSup;
	}
	
	public void setEstudioSup(String estudioSup) {
		this.estudioSup = estudioSup;
	}
	
	public long getEdad() {
		return edad;
	}
	
	public void setEdad(long edad) {
		this.edad = edad;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	public boolean validaUsuario() {
		boolean valida = true;
		if(this.nombres == "") {
			valida = false;
		}else if(this.apellidos== "") {
			valida = false;
		}else if(this.domicilio == "") {
			valida = false;
		}else if(this.curp == "") {
			valida = false;
		}else if(this.estudioSup == "") {
			valida = false;
		}else if(this.edad == 0) {
			valida = false;
		}
		return valida;
	}
}
