package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.swing.JOptionPane;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cancion;

public class ventanaUsuarioController {

	Main aplicacion;
	String correoUserIngresado;

	private ObservableList<Cancion> listaCancionesTodasData = FXCollections.observableArrayList();
	private ObservableList<Cancion> listaCancionesMiasData = FXCollections.observableArrayList();

	Cancion cancionSeleccionadaTodas;
	Cancion cancionSeleccionadaMias;

	FilteredList<Cancion> filteredCancionData;

	public String getCorreoUserIngresado() {
		return correoUserIngresado;
	}

	//Se guarda el email de usuario 
	public void setCorreoUserIngresado(String correoUserIngresado) {
		this.correoUserIngresado = correoUserIngresado;
	}

	@FXML
	private TableColumn<String, Cancion> columnNombTodas;

	@FXML
	private TableColumn<String, Cancion> columnArtiTodas;

	@FXML
	private TableView<Cancion> tablaListaTodasCanciones;

	@FXML
	private TableColumn<String, Cancion> columnNombMias;

	@FXML
	private TableColumn<Cancion, String> columnArtiMias;

	@FXML
	private TableView<Cancion> tablaListaMisCanciones;

	@FXML
	private TextField txtFilterCancion;

	@FXML
	void initialize() {
		this.columnNombTodas.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnArtiTodas.setCellValueFactory(new PropertyValueFactory<>("nomArtista"));

		tablaListaTodasCanciones.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldSelection, newSelection) -> {
					cancionSeleccionadaTodas = newSelection;
				});

		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		filteredCancionData = new FilteredList<>(listaCancionesTodasData, p -> true);

		// 2. Set the filter Predicate whenever the filter changes.
		txtFilterCancion.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredCancionData.setPredicate(cancion -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();

				if (cancion.getNombre().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				} else if (cancion.getNomArtista().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				} else if (cancion.getGenero().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});

		this.columnNombMias.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnArtiMias.setCellValueFactory(new PropertyValueFactory<>("nomArtista"));

		tablaListaMisCanciones.getSelectionModel().selectedItemProperty()
				.addListener((obs, oldSelection, newSelection) -> {
					cancionSeleccionadaMias = newSelection;
				});
	}

	@FXML
	void ordenarListaPorArtistas(ActionEvent event) {
		tablaListaMisCanciones.getSortOrder().clear();
		tablaListaMisCanciones.getSortOrder().add(columnArtiMias);
		tablaListaMisCanciones.refresh();

	}

	public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;

		// Se limpia y se inicializan todas las canciones en la tabla de todas las
		// canciones
		tablaListaTodasCanciones.getItems().clear();
		tablaListaTodasCanciones.setItems(getListaCan());

		// Para filtrar las canciones segun el parametro
		SortedList<Cancion> sortedCancionData = new SortedList<>(filteredCancionData);
		sortedCancionData.comparatorProperty().bind(tablaListaTodasCanciones.comparatorProperty());
		tablaListaTodasCanciones.setItems(sortedCancionData);


		tablaListaMisCanciones.getItems().clear();
		tablaListaMisCanciones.setItems(getListaCancionesMias());

	}

	private ObservableList<Cancion> getListaCancionesMias() {
	
		listaCancionesMiasData.addAll(aplicacion.obtenerListaUser(this.correoUserIngresado));
		return listaCancionesMiasData;
	}

	private ObservableList<Cancion> getListaCan() {
		listaCancionesTodasData.addAll(aplicacion.obtenerCanciones());
		return listaCancionesTodasData;
	}

	@FXML
	void AgregarALista(ActionEvent event) {
		if (cancionSeleccionadaTodas != null) {
			aplicacion.agregarCancionListaUser(correoUserIngresado, cancionSeleccionadaTodas);
			actualizarTablaMiLista();
		} else {
			mostrarMensajeError("Ninguna cancion ha sido seleccionada");
		}
	}

	private void actualizarTablaMiLista() {
		tablaListaMisCanciones.getItems().clear();
		tablaListaMisCanciones.setItems(getListaCancionesMias());
		tablaListaTodasCanciones.refresh();
	}

	@FXML
	void EliminarDeLista(ActionEvent event) {
		if (cancionSeleccionadaMias != null) {
			aplicacion.eliminarCancionUser(correoUserIngresado, cancionSeleccionadaMias);
			actualizarTablaMiLista();
		} else {
			mostrarMensajeError("Ninguna cancion ha sido seleccionada");
		}
	}

	@FXML
	void reproducirCancion(ActionEvent event) {
		try {
			abrirURL();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void abrirURL() throws URISyntaxException {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI("");
				if (cancionSeleccionadaTodas != null) {
					uri = new URI(cancionSeleccionadaTodas.getURL());
				}
				if (cancionSeleccionadaMias != null) {
					uri = new URI(cancionSeleccionadaMias.getURL());
				}
				desktop.browse(uri);
			} catch (IOException e) {
				mostrarMensajeError("No fue posible abrir el enlace " + e.getMessage());
			}
		} else {
			mostrarMensajeError("Solo pueden ingresar enlaces de YouTube");
		}
	}

	@FXML
	void Salir(ActionEvent event) {
		aplicacion.devolverLogin();
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
