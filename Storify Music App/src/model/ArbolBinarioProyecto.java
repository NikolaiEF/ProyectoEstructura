package model;

import java.io.Serializable;

/**
 * Clase que representa una estructura de datos tipo �rbol Binario de B�squeda
 *@author dbonilla
 * @param <T>
 */
public class ArbolBinarioProyecto<T extends Comparable<T>> implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Nodo<T> raiz;
	private int peso;

	/**
	 * Verifica si un �rbol est� vac�o
	 * @return true si est� vac�o
	 */
	public boolean estaVacio() {
		return raiz==null;
	}

	/**
	 * Agrega un nuevo elemento al �rbol
	 * @param elemento Nuevo dato
	 * @return true si lo pudo guardar
	 */
	public void agregar(T elemento) {
		//TODO debe aumentar el peso cada que se agregue un nuevo elemento
		if(estaVacio()) {
			raiz = new Nodo<>(elemento);
			peso++;
		}else if(raiz.agregar(elemento)) {
			peso++;
		}
	}

	/**
	 * Realiza el recorrido inorden en el �rbol binario
	 */
	public void inorden() {
		inorden(raiz);
	}

	/**
	 * Realiza el recorrido inorden en el �rbol binario
	 * @param n Nodo ra�z
	 */
	private void inorden(Nodo<T> n) {
		if(n!=null) {
			inorden(n.getIzquierdo());
			System.out.println(n.getElemento());
			inorden(n.getDerecho());
		}
	}

	/**
	 * Realiza el recorrido preorden en el �rbol binario
	 * @param n Nodo ra�z
	 */
	public void preorden(Nodo<T> n) {
		if(n!=null) {
			System.out.println(n.getElemento());
			preorden(n.getIzquierdo());
			preorden(n.getDerecho());
		}
	}

	/**
	 * Realiza el recorrido postorden en el �rbol binario
	 * @param n Nodo ra�z
	 */
	public void postorden(Nodo<T> n) {
		if(n!=null) {
			postorden(n.getIzquierdo());
			postorden(n.getDerecho());
			System.out.println(n.getElemento());
		}
	}

	/**
	 * Vetifica si un elemento existe en el �rbol binario
	 * @param n Nodo ra�z
	 * @param elemento Elemento a buscar
	 * @return true si lo encuentra
	 */
	public boolean existe(Nodo<T> n, T elemento) {
		if(n!=null) {
			if( elemento.compareTo(n.getElemento()) == 0 ) {
				return true;
			}else if( elemento.compareTo(n.getElemento()) < 0 ) {
				return existe(n.getIzquierdo(), elemento);
			}else if( elemento.compareTo(n.getElemento()) > 0 ) {
				return existe(n.getDerecho(), elemento);
			}
		}
		return false;
	}

	/**
	 * Cuenta todos los elementos que hay en el �rbol
	 * @param n Nodo ra�z
	 * @return Peso del �rbol
	 */
	public int obtenerPeso(Nodo<T> n) {

		if(n!=null) {
			return 1+obtenerPeso(n.getIzquierdo())+obtenerPeso(n.getDerecho());
		}

		return 0;
	}

	/**
	 * Devuelve la altura del �rbol
	 * @param n Nodo ra�z
	 * @return Altura del arbol
	 */
	public int obtenerAltura(Nodo<T> n, int prof) {
		if(n!=null) {
			int profIzq= obtenerAltura(n.getIzquierdo(),prof +1 );
			int profDer= obtenerAltura(n.getDerecho(),prof +1 );
		if (profIzq>=profDer)	{

			return profIzq;
		}else {

			return profDer;
		}


		}

		return prof;
	}

	/**
	 * Obtiene el nivel de un nodo
	 * @param nodo Nodo ra�z
	 * @param elemento, elemento a buscar
	 * @param nivel nivel del nodo
	 * @return nivel del nodo
	 */

public int obtenerNivel(Nodo <T> nodo, T elemento, int nivel) {

	if (nodo!=null) {
		if(elemento.compareTo(nodo.getElemento())==0) {
			return nivel;
		} else if (elemento.compareTo(nodo.getIzquierdo().getElemento())<0) {
			return obtenerNivel(nodo.getIzquierdo(), elemento, nivel+1);
		}
		else if (elemento.compareTo(nodo.getDerecho().getElemento())>0) {
			return obtenerNivel(nodo.getDerecho(), elemento, nivel+1);

		   }
		}
	return -1;
	}

/**
 * Cuenta el numero de hojas
 * @param n, nodo ra�z
 * @return numero de hojas del �rbol
 */
public int contarHojas(Nodo <T> n ) {
	if (n!=null) {
		 int c=0;
		if (n.esHoja()) {
			c=1;
		}
		return c+ contarHojas(n.getIzquierdo())+contarHojas(n.getDerecho());

	}
	return 0;

}

/**
 * Obtiene el menor no recursivo
 * @return elemento menor del arbol
 */
public T obtenerMenor () {
	Nodo <T> aux = raiz;

	 while (aux.getIzquierdo()!=null) {
		 aux = aux.getIzquierdo();
		 }
	return aux.getElemento();
}

public void imprimirHorizontal(Nodo <T> n, int nivel) {
	if (n!=null) {
		 imprimirHorizontal(n.getDerecho(), nivel+1);

		 for (int i = 0; i < nivel; i++) {
			 System.out.println("/t");

		}

		 System.out.println(n.getElemento());

		 imprimirHorizontal(n.getIzquierdo(), nivel+1);

	}


}





/**
 * Obtiene el menor recursivamente
 * @param n, nodo  raiz
 * @return elemento menor del arbol
 */
public T obtenerMenor (Nodo <T> n) {
	if (n.getIzquierdo()!=null) {
		return obtenerMenor(n.getIzquierdo());
	}
	 return n.getElemento();
}

	/**
	 * @return the raiz
	 */
	public Nodo<T> getRaiz() {
		return raiz;
	}
	/**
	 * @param raiz the raiz to set
	 */
	public void setRaiz(Nodo<T> raiz) {
		this.raiz = raiz;
	}
	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}


}