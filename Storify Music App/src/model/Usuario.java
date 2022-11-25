package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario {

	private String nombre, apellido, correo, clave, confClave1;
	ListaDoble <Cancion> listaRepr = new ListaDoble<Cancion>();
	ArrayList<Cancion> listaCancionesView = new ArrayList<Cancion>();

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String correo, String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getConfClave1() {
		return confClave1;
	}

	public void setConfClave1(String confClave1) {
		this.confClave1 = confClave1;
	}



	public ListaDoble<Cancion> getListaRepr() {
		return listaRepr;
	}

	public ArrayList<Cancion> getListaReprtoArray() {
		return listaRepr.getContent();
	}



	public void setListaRepr(ListaDoble<Cancion> listaRepr) {
		this.listaRepr = listaRepr;
	}

	public ArrayList<Cancion> getListaCanciones() {
		return listaCancionesView;
	}

	public void setListaCanciones(ArrayList<Cancion> listaCanciones) {
		this.listaCancionesView = listaCanciones;
	}

	public void agregarCancionMiLista(Cancion cancion){
		boolean existe = false;
		for (Cancion c : listaCancionesView) {
			if (c.getNombre().equalsIgnoreCase(cancion.getNombre())) {
				existe = true;
				JOptionPane.showMessageDialog(null, "La cancion no fue agregada porque ya está agregada");
			}
		}
		if (existe == false) {
			listaRepr.agregarfinal(cancion);
			listaCancionesView.add(cancion);
			JOptionPane.showMessageDialog(null, "La cancion  fue agregada exitosamente a tu lista");
		}
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", clave=" + clave + "]";
	}

	public void eliminarCancionMiLista(Cancion cancionSeleccionadaMias) {
		listaRepr.eliminar(cancionSeleccionadaMias);
		listaCancionesView.remove(cancionSeleccionadaMias);
		JOptionPane.showMessageDialog(null, "La cancion ha sido eliminada con exito");
	}


}
