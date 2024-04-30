package com.example.recar.recar.models;

public class Operacion {
	
	private String dni;
	private String nombre;
	private String matricula;
	private int interior;
	private int exterior;
	private int completo;
	private int ozono;
	private double repostaje;
	private String observaciones;
    private String codigo;
    
    public Operacion() {

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getInterior() {
		return interior;
	}

	public void setInterior(int interior) {
		this.interior = interior;
	}

	public int getExterior() {
		return exterior;
	}

	public void setExterior(int exterior) {
		this.exterior = exterior;
	}

	public int getCompleto() {
		return completo;
	}

	public void setCompleto(int completo) {
		this.completo = completo;
	}

	public int getOzono() {
		return ozono;
	}

	public void setOzono(int ozono) {
		this.ozono = ozono;
	}

	public double getRepostaje() {
		return repostaje;
	}

	public void setRepostaje(double repostaje) {
		this.repostaje = repostaje;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}    
    
}
