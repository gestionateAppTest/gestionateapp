package com.gestionate.api.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 9080441927787347734L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido1")
	private String apellido1;
	
	@Column(name = "apellido2")
	private String apellido2;
	
	@Column(name = "activo")
	private String activo;
	
	@Column(name = "f_baja")
	private String f_baja;
	
	@Column(name = "f_ult_inicio_sesion")
	private Date f_ult_inicio_sesion;

	public Usuario(long id, String username, String email, String password, String nombre, String apellido1,
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

	public Usuario() {
		super();
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
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", activo=" + activo
				+ ", f_baja=" + f_baja + ", f_ult_inicio_sesion=" + f_ult_inicio_sesion + "]";
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
		Usuario other = (Usuario) obj;
		return Objects.equals(activo, other.activo) && Objects.equals(apellido1, other.apellido1)
				&& Objects.equals(apellido2, other.apellido2) && Objects.equals(email, other.email)
				&& Objects.equals(f_baja, other.f_baja)
				&& Objects.equals(f_ult_inicio_sesion, other.f_ult_inicio_sesion) && id == other.id
				&& Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}


	
	
	
	

}
