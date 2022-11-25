package model;

import java.io.Serializable;

public class NodoLista<T> implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private NodoLista<T> anterior, siguiente;
	private T dato;

	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 * @param anterior Enlace al Nodo anterior
	 * @param siguiente Enlace al siguiente Nodo
	 */
	public NodoLista(NodoLista<T> anterior, NodoLista<T> siguiente, T dato) {
		super();
		this.anterior = anterior;
		this.siguiente = siguiente;
		this.dato = dato;
	}

	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 */
	public NodoLista(T dato) {
		this.dato = dato;
	}

	/**
	 * @return the anterior
	 */
	public NodoLista<T> getAnterior() {
		return anterior;
	}
	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(NodoLista<T> anterior) {
		this.anterior = anterior;
	}
	/**
	 * @return the siguiente
	 */
	public NodoLista<T> getSiguiente() {
		return siguiente;
	}
	/**
	 * @param siguiente the siguiente to set
	 */
	public void setSiguiente(NodoLista<T> siguiente) {
		this.siguiente = siguiente;
	}
	/**
	 * @return the dato
	 */
	public T getDato() {
		return dato;
	}
	/**
	 * @param dato the dato to set
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}

	@Override
	public String toString() {
		return dato.toString();
	}

}