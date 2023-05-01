package com.gestionate.api.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingresos")
public class Ingresos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ingreso")
	private long id;
	
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	
	@Column(name="cantidad")
	private double cantidad;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	public Ingresos(long id, Date fecha_ingreso, double cantidad, String descripcion, Usuario usuario) {
		super();
		this.id = id;
		this.fecha_ingreso = fecha_ingreso;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}

	public Ingresos() {
		super();
	}


	public Ingresos(long id, Date fecha_ingreso, double cantidad, String descripcion) {
		super();
		this.id = id;
		this.fecha_ingreso = fecha_ingreso;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, fecha_ingreso, id, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingresos other = (Ingresos) obj;
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fecha_ingreso, other.fecha_ingreso)
				&& id == other.id && Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Ingresos [id=" + id + ", fecha_ingreso=" + fecha_ingreso + ", cantidad=" + cantidad + ", descripcion="
				+ descripcion + ", usuario=" + usuario + "]";
	}
	
	
	
}
