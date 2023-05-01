package com.gestionate.api.dto;

import java.sql.Date;
import java.util.Objects;

import com.gestionate.api.entities.Usuario;

public class UsuarioDTO {

	private long id;
	private String username;
	private String email;
	private String password;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String activo;
	private String f_baja;	
	private Date f_ult_inicio_sesion;
	
	public Usuario obtenerDeDTO(UsuarioDTO usuario) {
		
		Usuario usuarioEntidad = null; 
		
		if(usuario != null) {
			usuarioEntidad = new Usuario(
					usuario.getId(), 
					usuario.getUsername(),
					usuario.getEmail(),
					usuario.getPassword(),
					usuario.getNombre(),
					usuario.getApellido1(),
					usuario.getApellido2(),
					usuario.getActivo(),
					usuario.getF_baja(),
					usuario.getF_ult_inicio_sesion());
		}
		
		return usuarioEntidad;
	}
	
	public UsuarioDTO(Usuario usuario) {
		super();
		
		if(usuario != null) {
				this.id = usuario.getId(); 
				this.username = usuario.getUsername();
				this.email = usuario.getEmail();
				this.password = usuario.getPassword();
				this.nombre = usuario.getNombre();
				this.apellido1 = usuario.getApellido1();
				this.apellido2 = usuario.getApellido2();
				this.activo = usuario.getActivo();
				this.f_baja = usuario.getF_baja();
				this.f_ult_inicio_sesion = usuario.getF_ult_inicio_sesion();
		}
	}

	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(long id, String username, String email, String password, String nombre, String apellido1,
			String apellido2, String activo, String f_baja, Date f_ult_inicio_sesion) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.activo = activo;
		this.f_baja = f_baja;
		this.f_ult_inicio_sesion = f_ult_inicio_sesion;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getF_baja() {
		return f_baja;
	}
	public void setF_baja(String f_baja) {
		this.f_baja = f_baja;
	}
	public Date getF_ult_inicio_sesion() {
		return f_ult_inicio_sesion;
	}
	public void setF_ult_inicio_sesion(Date f_ult_inicio_sesion) {
		this.f_ult_inicio_sesion = f_ult_inicio_sesion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, apellido1, apellido2, email, f_baja, f_ult_inicio_sesion, id, nombre, password,
				username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(activo, other.activo) && Objects.equals(apellido1, other.apellido1)
				&& Objects.equals(apellido2, other.apellido2) && Objects.equals(email, other.email)
				&& Objects.equals(f_baja, other.f_baja)
				&& Objects.equals(f_ult_inicio_sesion, other.f_ult_inicio_sesion) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
}
