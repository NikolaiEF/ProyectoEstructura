package application;


import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JOptionPane;

import archivos.Persistencia;
import controller.CancionVIewController;
import controller.CrearUserController;
import controller.LoginController;
import controller.ventanaAdminController;
import controller.ventanaCrearArtista;
import controller.ventanaUsuarioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Artista;
import model.Cancion;
import model.Reproductor;


public class Main extends Application {

	private Stage primaryStage;
	private Reproductor storify = Persistencia.cargarRecursoXML();

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * En este espacio se encuentran los metodos para mostrar las diferentes
	 * views del programa (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Storify Music");
		this.primaryStage.setResizable(false);
		mostrarVentanaBienvenida();
		System.out.println("que rico");

	}

	public void mostrarVentanaBienvenida() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			LoginController loginController = loader.getController();
			loginController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCrearUsuario() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/agregarUsuarioView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			CrearUserController crearUserController = loader.getController();
			crearUserController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaUsuario(String usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/UsuarioView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			ventanaUsuarioController ventanaUsuario = loader.getController();
			ventanaUsuario.setCorreoUserIngresado(usuario);
			ventanaUsuario.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/adminisView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			ventanaAdminController ventanaAdmin = loader.getController();
			ventanaAdmin.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCrearArtista() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/CrearArtistaView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			ventanaCrearArtista ventanaCrearArt = loader.getController();
			ventanaCrearArt.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mostrarVentanaCancion() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/CancionView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			CancionVIewController ventanaCancion = loader.getController();
			ventanaCancion.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * En este espacio se encuentran los metodos para el ingreso de usuarios y
	 * administrador
	 */

	public void ingresarUsuario(String usuario, String contrasena) {
		boolean verify = storify.ingresarUser(usuario, contrasena);
		if (verify) {
			mostrarVentanaUsuario(usuario);
		} else {
			mostrarMensajeError("Los datos ingresados estan errados");
		}
	}

	public void ingresarAdmin(String usuario, String contrasena) {
		boolean verify = storify.ingresarAdmin(usuario, contrasena);
		if (verify) {
			mostrarVentanaAdmin();
		} else {
			mostrarMensajeError("Los datos ingresados estan errados");
		}

	}

	/*
	 * En este espacio se encuentran los metodos para crear los distintos
	 * objetos
	 */

	public void crearArt() {
		mostrarVentanaCrearArtista();

	}

	public void crearUsuario(String nombre, String apellido, String clave, String correo) {
		boolean verify = storify.crearUser(nombre, apellido, clave, correo);
		if (verify) {
			mostrarVentanaBienvenida();
		} else {
			mostrarMensajeError("El usuario no puede ser creado");
		}

	}

	public void crearArtistaFull(String nombre, String nacionalidad, String codigo, String genero, boolean duo) {
		boolean verify = storify.crearArtista(nombre, nacionalidad, codigo, genero, duo);
		if (verify) {
			mostrarVentanaAdmin();
		} else {
			mostrarMensajeError("Los datos ingresados estan errados");
		}
	}

	public void crearCancion(String duracion, String nombre, String album, String anio, String uRL, String artista,
			String codigo, String genero) {
		boolean verify = storify.crearCanc(duracion, nombre, album, anio, uRL, artista, codigo, genero);

		if (verify) {
			mostrarVentanaAdmin();
		} else {
			mostrarMensajeError("Los datos ingresados estan errados");
		}

	}

	public void subirCancion() {
		mostrarVentanaCancion();
	}

	public void devolverInicio() {
		mostrarVentanaAdmin();
	}

	public void devolverLogin() {
		mostrarVentanaBienvenida();
	}

	public String generarCodigo() {
		String codi = storify.generarCod();
		return codi;

	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ArrayList<Artista> obtenerArtista() {
		return storify.retornarArray();
	}

	public ArrayList<Cancion> obtenerCanciones() {
		return storify.listaCancionesArray();
	}

	public ArrayList<Cancion> obtenerListaUser(String correoUserIngresado) {
		return storify.obtenerListaUser(correoUserIngresado);
	}

	public ArrayList<Cancion> buscarCanArt(String autor) {
		ArrayList<Cancion> lista = new ArrayList<>();
		lista = storify.buscarCArt(autor);
		return lista;
	}

	public void agregarCancionListaUser(String correoUserIngresado, Cancion cancionSeleccionadaTodas) {
		storify.agregarCancionListaUser(correoUserIngresado, cancionSeleccionadaTodas);
	}

	public void eliminarCancionUser(String correoUserIngresado, Cancion cancionSeleccionadaMias) {
		storify.eliminarCancionListaUser(correoUserIngresado, cancionSeleccionadaMias);
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


