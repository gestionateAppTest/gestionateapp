package com.gestionate.api.dto;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.NotEmpty;


public class IngresoDTO {
	
	private long id;
	
	@NotEmpty
	private Date fecha_ingreso;
	
	@NotEmpty
	@NumberFormat
	private double cantidad;
	
	@NotEmpty
	private String descripcion;
	
	public IngresoDTO() {
		super();
	}
	
	public IngresoDTO(long id, Date fecha_ingreso, double cantidad, String descripcion) {
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

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, fecha_ingreso, id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngresoDTO other = (IngresoDTO) obj;
		return Double.doubleToLongBits(cantidad) == Double.doubleToLongBits(other.cantidad)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fecha_ingreso, other.fecha_ingreso)
				&& id == other.id;
	}
	
}
