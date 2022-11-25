package model;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import model.ListaDoble;

public class Reproductor implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Hashtable<String, Usuario> tablaUsuarios = new Hashtable<>();
	Hashtable<String, Administrador> tablaAdmin = new Hashtable<>();
	ArbolBinarioProyecto<Artista> arbolArtista = new ArbolBinarioProyecto<Artista>();
	ListaDoble<Cancion> canciones = new ListaDoble<>();
	ArrayList<Artista> artistaInterfaz = new ArrayList<>();

	public Reproductor() {
		super();
		quemarDatosAdmin();
		inicializarDatos();
	}

	private void inicializarDatos() {
		Usuario usr1 = new Usuario("Nico", "Eche", "correo", "Nico");
		tablaUsuarios.put("correo", usr1);


		Artista a1 = new Artista("Jeanette", "1", "Colombiana", "balada", false);
		Artista a2 = new Artista("Jeanette", "2", "Colombiana", "balada", false);
		Artista a3 = new Artista("Melendi", "3", "Espanol", "rock", false);

		arbolArtista.agregar(a1);
		arbolArtista.agregar(a2);
		arbolArtista.agregar(a3);

		artistaInterfaz.add(a1);
		artistaInterfaz.add(a2);
		artistaInterfaz.add(a3);

		Cancion c1 = new Cancion("Por que te vas", "1",  "balada", "2002", "https://www.youtube.com/watch?v=TjUhXbGdLYo" , "Jeanette");
		Cancion c2 = new Cancion("Frente a Frente", "2",  "balada", "2002", "https://www.youtube.com/watch?v=6ys7i-kW-lQ&list=RDTjUhXbGdLYo&index=5" , "Jeanette");
		Cancion c3 = new Cancion("Violinista en tu tejado", "3", "rock", "2013",  "https://www.youtube.com/watch?v=6YOWIaGLWe8" , "Melendi");

		canciones.agregarfinal(c1);
		canciones.agregarfinal(c2);
		canciones.agregarfinal(c3);

		ArrayList<Cancion> usrCanciones = new ArrayList<>();
		usrCanciones.add(c1);
		usrCanciones.add(c2);
		usrCanciones.add(c3);

		ListaDoble<Cancion> usrCan = new ListaDoble<>();
		for (Cancion cancion : usrCanciones) {
			usrCan.agregarfinal(cancion);
		}
	}



	private void quemarDatosAdmin() {
		// TODO Auto-generated method stub
		Administrador admin1 = new Administrador("admin", "admin");
		tablaAdmin.put("admin", admin1);
//		Administrador admin2 = new Administrador("1", "1");
//		tablaAdmin.put("1", admin2);
	}




	public boolean crearUser(String nombre, String apellido, String clave, String correo) {

		Usuario newUser = new Usuario();

		newUser.setCorreo(correo);
    	newUser.setNombre(nombre);
    	newUser.setApellido(apellido);
    	newUser.setClave(clave);

    	if(tablaUsuarios.containsKey(newUser.getCorreo())==false){

    		JOptionPane.showMessageDialog(null, "el usuario ha sido creado correctamente");
    		tablaUsuarios.put(newUser.getCorreo(), newUser);
    		JOptionPane.showMessageDialog(null, "los registrados son:" + tablaUsuarios);

    		return true;
    }else{
    	JOptionPane.showMessageDialog(null, "ya existe un usuario con este correo, intentelo con un correo diferente");
    	return false;
    	}
	}



	public boolean ingresarUser(String correo, String contrasena) {

		Usuario user = tablaUsuarios.get(correo);
		if(user!=null && user.getClave().equals(contrasena)){
			return true;
		}else{
		return false;
		}
	}



	public boolean ingresarAdmin(String correo, String contrasena) {
		// TODO Auto-generated method stub
		Administrador admin = tablaAdmin.get(correo);
		if(admin!=null && admin.getClave().equals(contrasena)){
			return true;
		}else{
		return false;
		}
	}



	public boolean crearArtista(String nombre, String nacionalidad, String codigo, String genero, boolean duo) {

		Artista art = new Artista();
		art.setCodigo(codigo);
		art.setDuo(duo);
		art.setGenero(genero);
		art.setNacionalidad(nacionalidad);
		art.setNombre(nombre);

		if(arbolArtista.estaVacio()){
			arbolArtista.agregar(art);
			this.artistaInterfaz.add(art);
			JOptionPane.showMessageDialog(null, "el artista ha sido creado correctamente");
			return true;
		}else if(!arbolArtista.existe(arbolArtista.getRaiz(), art)){
			arbolArtista.agregar(art);
			this.artistaInterfaz.add(art);
			JOptionPane.showMessageDialog(null, "el artista ha sido creado correctamente");
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "ya existe un artista con este nombre, intentelo con un nombre diferente");
			return false;
		}


	}

	public ArrayList<Artista> retornarArray(){

		return this.artistaInterfaz;
	}





	public boolean subirCancion() {
		// TODO Auto-generated method stub
		return false;
	}



	public String generarCod() {

		    // las cadenas al azar
		
		    String caracters = "abcdefghijklmnopqrstuvwxyz";
		    String caracters_aux = caracters.toUpperCase();
		    String numbers = "0123456789";

		    String caractersAleatorios = caracters + caracters_aux + numbers;
		    SecureRandom random = new SecureRandom();

		    StringBuilder sb = new StringBuilder(5);

		    for (int i = 0; i < 10; i++) {
		        // 0-62 (exclusive), retornos aleatorios 0-61
		        int rndCharAt = random.nextInt(caractersAleatorios.length());
		        char rndChar = caractersAleatorios.charAt(rndCharAt);

		        sb.append(rndChar);
		    }

		    return sb.toString();
		}



	public boolean crearCanc(String nombre, String album, String uRL, String artista,
			String codigo, String genero) {


		Cancion cancion = new Cancion();
		cancion.setGenero(genero);
		cancion.setNombre(nombre);
		cancion.setURL(uRL);
		cancion.setNomArtista(artista);

		if(!canciones.existe(cancion.getCodigo())){
			canciones.agregarfinal(cancion);
			JOptionPane.showMessageDialog(null, "la cancion ha sido creada correctamente");
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "la cancion no ha sido creada");
			return false;
		}
	}


	public ArrayList<Cancion> listaCancionesArray() {
		ArrayList<Cancion> listCanciones = new ArrayList<>();
		listCanciones=canciones.getContent();
		return listCanciones;
	}

	public ArrayList<Cancion> obtenerListaUser(String correoUserIngresado) {
		//ACA SE OBTIENE EL USUARIO GRACIAS AL CORREO
		Usuario user = buscarUsuarioCorreo(correoUserIngresado);
		ArrayList<Cancion> listaUser = user.getListaCanciones();
		return listaUser;
	}

	private Usuario buscarUsuarioCorreo(String correoUserIngresado) {
		//NO SE NECESITA VALIDAR PORQUE LA VALIDACION SE HIZO EN EL LOGIN
		return tablaUsuarios.get(correoUserIngresado);
	}

	public ArrayList<Cancion> obtenerCancionesArtista(){
		ArrayList<Cancion> lista = new ArrayList<Cancion>();

		return lista;
	}

	public ArrayList<Cancion> buscarCArt(String autor) {
		// TODO Auto-generated method stub
		ArrayList<Cancion> lista = new ArrayList<Cancion>();
		ListaDoble<Cancion> cancionesArt = new ListaDoble<Cancion>();

		Artista artistaAux = null;
		artistaAux = buscarArtistaNombre(autor);
		NodoLista<Cancion> can = canciones.getNodoPrimero();
		if(artistaAux!=null){
			if(artistaAux.getCancionesArtista()==null){
				for(Cancion cancion:canciones){
					//System.out.println(""+canciones);
					if (can != null) {
						System.out.println(can.getDato());
						System.out.println(can.getDato().getNomArtista());
						System.out.println(autor);
						if(can.getDato().getNomArtista().contains(autor)){
							System.out.println("segundo");
							cancionesArt.agregarfinal(cancion);
							lista.add(cancion);
							can = can.getSiguiente();
						}else{
							can.getSiguiente();
							System.out.println("tercero");
						}
					}
				}
				artistaAux.setCancionesArtista(cancionesArt);


				return lista;
			}

			 return lista;

		}
		return lista;
	}

	private Artista buscarArtistaNombre(String autor) {
		// TODO Auto-generated method stub

		for (Artista artista : artistaInterfaz) {
			if(artista.getNombre().equals(autor)){
				return artista;
			}
		}
		return null;
	}



	public ArrayList<Cancion> devolverCanciones(){
		ArrayList<Cancion> lista = new ArrayList<Cancion>();

		return lista;
	}

	public void agregarCancionListaUser(String correoUserIngresado, Cancion cancionSeleccionadaTodas) {
		Usuario usr = buscarUsuarioCorreo(correoUserIngresado);
		usr.agregarCancionMiLista(cancionSeleccionadaTodas);
	}

	public void eliminarCancionListaUser(String correoUserIngresado, Cancion cancionSeleccionadaMias) {
		Usuario usr = buscarUsuarioCorreo(correoUserIngresado);
		usr.eliminarCancionMiLista(cancionSeleccionadaMias);
	}




}






