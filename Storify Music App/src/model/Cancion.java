package model;

import java.io.Serializable;

public class Cancion implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String nombre, codigo, album, genero, URL, nomArtista;

	public Cancion(String nombre, String codigo, String album, String genero,
			String uRL, String nomArtista) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.album = album;
		this.genero = genero;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", codigo=" + codigo + "]";
	}




}
