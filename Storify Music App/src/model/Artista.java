package model;

import java.io.Serializable;

public class Artista implements Comparable<Artista>, Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String nombre, codigo, nacionalidad, genero ;
	boolean isDuo;
	ListaDoble<Cancion> cancionesArtista;

	public Artista(String nombre, String codigo, String nacionalidad, String genero, boolean isDuo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.nacionalidad = nacionalidad;
		this.genero = genero;
		this.isDuo = isDuo;
	}

	public Artista() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public boolean isDuo() {
		return isDuo;
	}
	public void setDuo(boolean isDuo) {
		this.isDuo = isDuo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void agregarArtista (Artista art){

	}


	public ListaDoble<Cancion> getCancionesArtista() {
		return cancionesArtista;
	}
	public void setCancionesArtista(ListaDoble<Cancion> cancionesArtista) {
		this.cancionesArtista = cancionesArtista;
	}
	@Override
	public String toString() {
		return " " + codigo + "\n";
	}
	@Override
	public int compareTo(Artista o) {
		if (o.getNombre().hashCode() > this.getNombre().hashCode()){
			return 1;
		}
		if (o.getNombre().hashCode() < this.getNombre().hashCode()){
			return -1;
		}
		return 0;
	}




}
