package edu.Parcial.ParcialApp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	@Column(name="descripcion",nullable=false)
	public String descripcion;
	
	@Column(name="prioridad",nullable=false)
	public String prioridad;
	
	
	@Column(name="fechaInicio",nullable=false)
	private Date fechaInicio;
	
	@Column(name="fechaFin",nullable=false)
	private Date fechaFin;
	
	@Column(name="estado",nullable=false)
	private Integer estado;
	
	@Column(name="programador",nullable=false)
	private String programador;
	
	@ManyToOne
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getProgramador() {
		return programador;
	}

	public void setProgramador(String programador) {
		this.programador = programador;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
}
