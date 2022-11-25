package model;

import java.io.Serializable;

/**
 * Clase que representa un Nodo del �rbol binario
 * @author dbonilla
 *
 * @param <T>
 */
public class Nodo<T extends Comparable<T>> implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Nodo<T> izquierdo, derecho;
	private T elemento;

	/**
	 * Constructor de la clase
	 * @param elemento Dato del nodo
	 */
	public Nodo(T elemento) {
		this.elemento = elemento;
	}

	/**
	 * Agrega un nuevo elemento en el �rbol
	 * @param elemento Nuevo dato
	 * @return true si lo pudo guardar
	 */
	public boolean agregar(T nuevo) {
		if( nuevo.compareTo( elemento ) < 0 ) {
			if(izquierdo==null) {
				izquierdo = new Nodo<>(nuevo);
				return true;
			}else {
				return izquierdo.agregar(nuevo);
			}
		}else if( nuevo.compareTo( elemento ) > 0 ) {
			if(derecho==null) {
				derecho = new Nodo<>(nuevo);
				return true;
			}else {
				return derecho.agregar(nuevo);
			}
		}
		return false;
	}
	/**
	 * Dice cuando un nodo es una hoja o no
	 * @return true si el nodo es hoja
	 */
	public boolean esHoja() {

		return izquierdo==null && derecho==null;
	}



	/**
	 * @return the izq
	 */
	public Nodo<T> getIzquierdo() {
		return izquierdo;
	}

	/**
	 * @param izq the izq to set
	 */
	public void setIzquierdo(Nodo<T> izq) {
		this.izquierdo = izq;
	}

	/**
	 * @return the der
	 */
	public Nodo<T> getDerecho() {
		return derecho;
	}

	/**
	 * @param der the der to set
	 */
	public void setDerecho(Nodo<T> der) {
		this.derecho = der;
	}

	/**
	 * @return the elemento
	 */
	public T getElemento() {
		return elemento;
	}

	/**
	 * @param elemento the elemento to set
	 */
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}




}