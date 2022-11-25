package model;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Usuario {

	private String nombre, apellido, correo, clave, confClave1;
	ListaDoble<Cancion> listaRepr = new ListaDoble<Cancion>();
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

	public void agregarCancionMiLista(Cancion cancion) {
		boolean existe = false;
		for (Cancion c : listaCancionesView) {
			if (c.getNombre().equalsIgnoreCase(cancion.getNombre())) {
				existe = true;
				mostrarMensajeError("Esta cancion ya fue agregada");
			}
		}
		if (existe == false) {
			listaRepr.agregarfinal(cancion);
			listaCancionesView.add(cancion);
			mostrarMensajeError("Se a agregado la cancion");
		}
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", clave=" + clave + "]";
	}

	public void eliminarCancionMiLista(Cancion cancionSeleccionadaMias) {
		listaRepr.eliminar(cancionSeleccionadaMias);
		listaCancionesView.remove(cancionSeleccionadaMias);
		mostrarMensajeInformacion("La cancion fue eliminada");
	}

	private boolean mostrarMensajeInformacion(String mensaje) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Informacion");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	private boolean mostrarMensajeError(String mensaje) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Confirmacion");
		alert.setContentText(mensaje);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

}
