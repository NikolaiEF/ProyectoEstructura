package model;

import java.io.Serializable;

public class Administrador implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre, clave;



	public Administrador(String nombre, String clave) {
		super();
		this.nombre = nombre;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + "]";
	}





}
