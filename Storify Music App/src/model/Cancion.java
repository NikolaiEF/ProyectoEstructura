package model;

import java.io.Serializable;

public class Cancion implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String nombre, codigo, album, genero, caratula, anio,duracion, URL, nomArtista;

	public Cancion(String nombre, String codigo, String album, String genero, String caratula, String anio,
			String duracion, String uRL, String nomArtista) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.album = album;
		this.genero = genero;
		this.caratula = caratula;
		this.anio = anio;
		this.duracion = duracion;
		this.URL = uRL;
		this.nomArtista = nomArtista;
	}

	public Cancion() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNomArtista() {
		return nomArtista;
	}

	public void setNomArtista(String nomArtista) {
		this.nomArtista = nomArtista;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCaratula() {
		return caratula;
	}

	public void setCaratula(String caratula) {
		this.caratula = caratula;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", codigo=" + codigo + "]";
	}








}
