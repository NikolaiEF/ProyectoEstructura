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
		quemarDatos();
	}

	private void quemarDatos() {
		Usuario usr1 = new Usuario("Juan", "Brito", "alambrito@qlo.lor", "epenleatsugel");
		Usuario usr2 = new Usuario("Alejandro", "Herez", "alejandrito@qlo.lor", "epenleatsugel");
		Usuario usr3 = new Usuario("Pablo", "Nelson", "pablito@qlo.lor", "epenleatsugel");
		tablaUsuarios.put("alambrito@qlo.lor", usr1);
		tablaUsuarios.put("alejandrito@qlo.lor", usr2);
		tablaUsuarios.put("pablito@qlo.lor", usr3);

		Artista a1 = new Artista("Jose Jose", "1", "Colombiana", "balada", false);
		Artista a2 = new Artista("Jeanette", "2", "Colombiana", "balada", false);
		Artista a3 = new Artista("Calamaro", "3", "Argentino", "rock", false);
		Artista a4 = new Artista("Daft Punk", "4", "Estado Unidense", "pop", false);
		Artista a5 = new Artista("Gnarls", "5", "Estado Unidense", "alternativo", false);
		Artista a6 = new Artista("Nolan", "6", "Estado Unidense", "alternativo", false);
		arbolArtista.agregar(a1);
		arbolArtista.agregar(a2);
		arbolArtista.agregar(a3);
		arbolArtista.agregar(a4);
		arbolArtista.agregar(a5);
		arbolArtista.agregar(a6);

		artistaInterfaz.add(a1);
		artistaInterfaz.add(a2);
		artistaInterfaz.add(a3);
		artistaInterfaz.add(a4);
		artistaInterfaz.add(a5);
		artistaInterfaz.add(a6);


		Cancion c1 = new Cancion("El triste", "1", "lostristes", "balada", "catarula", "2002", "2:20", "https://www.youtube.com/watch?v=E20G25SCAEg&ab_channel=Jos%C3%A9Jos%C3%A9Oficial" , "Jose Jose");
		Cancion c2 = new Cancion("Amar y querer", "2", "lostristes", "balada", "catarula", "2020", "3:20", "https://www.youtube.com/watch?v=a3xjfTEXFWg&ab_channel=Jos%C3%A9Jos%C3%A9-Topic" , "Jose Jose");
		Cancion c3 = new Cancion("Por que te vas", "3", "porktevas", "balada", "catarula", "2018", "2:20", "https://www.youtube.com/watch?v=TjUhXbGdLYo&ab_channel=Jeanette" , "Jeanette");
		Cancion c4 = new Cancion("Flaca", "4", "losflacos", "rock", "catarula", "2002", "6:20", "https://www.youtube.com/watch?v=uEV4RqqnlSE&ab_channel=Andr%C3%A9sCalamaro-Topic" , "Calamaro");
		Cancion c5 = new Cancion("Instant Crush", "5", "instant", "pop", "catarula", "2002", "4:20", "https://www.youtube.com/watch?v=a5uQMwRMHcs&ab_channel=DaftPunkVEVO" , "Daft Punk");
		Cancion c6 = new Cancion("Something About Us", "6", "instant", "pop", "catarula", "2002", "2:20", "https://www.youtube.com/watch?v=E20G25SCAEg&ab_channel=Jos%C3%A9Jos%C3%A9Oficial" , "Daft Punk");
		Cancion c7 = new Cancion("Crazy", "7", "loscreisis", "alternativo", "catarula", "2002", "3:20", "https://www.youtube.com/watch?v=-N4jf6rtyuw&ab_channel=GnarlsBarkleyOfficial" , "Gnarls");
		Cancion c8 = new Cancion("Interestellar", "8", "teamonolan", "alternativo", "catarula", "2002", "2:20", "https://www.youtube.com/watch?v=UDVtMYqUAyw&ab_channel=Cin%C3%A9mavore" , "Nolan");
		canciones.agregarfinal(c1);
		canciones.agregarfinal(c2);
		canciones.agregarfinal(c3);
		canciones.agregarfinal(c4);
		canciones.agregarfinal(c5);
		canciones.agregarfinal(c6);
		canciones.agregarfinal(c7);
		canciones.agregarfinal(c8);

		ArrayList<Cancion> usrCanciones = new ArrayList<>();
		usrCanciones.add(c1);
		usrCanciones.add(c2);
		usrCanciones.add(c3);
		usr3.setListaCanciones(usrCanciones);
		ListaDoble<Cancion> usrCan = new ListaDoble<>();
		for (Cancion cancion : usrCanciones) {
			usrCan.agregarfinal(cancion);
		}
		usr3.setListaRepr(usrCan);
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
		// TODO Auto-generated method stub

		    // Puede personalizar los personajes que desea agregar a
		    // las cadenas al azar
		    String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		    String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		    String NUMBER = "0123456789";

		    String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
		    SecureRandom random = new SecureRandom();

		    StringBuilder sb = new StringBuilder(5);

		    for (int i = 0; i < 10; i++) {
		        // 0-62 (exclusive), retornos aleatorios 0-61
		        int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
		        char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

		        sb.append(rndChar);
		    }

		    return sb.toString();
		}



	public boolean crearCanc(String duracion, String nombre, String album, String anio, String uRL, String artista,
			String codigo, String genero) {


		Cancion cancion = new Cancion();

		cancion.setAlbum(album);
		cancion.setAnio(anio);
		cancion.setCodigo(codigo);
		cancion.setDuracion(duracion);
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






