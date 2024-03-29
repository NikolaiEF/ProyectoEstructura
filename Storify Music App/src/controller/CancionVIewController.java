package controller;

import java.io.File;
import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class CancionVIewController {

	Main aplicacion;

	public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	private RadioButton RBreggaeton;

	@FXML
	private RadioButton RBpop;

	@FXML
	private ImageView IMVcaratula;

	@FXML
	private TextField txtNombCancion;

	@FXML
	private ToggleGroup GeneroCancion;

	@FXML
	private TextArea txtCodigo;

	@FXML
	private RadioButton RBelectronica;

	@FXML
	private RadioButton RBrock;

	@FXML
	private TextField txtDuracion;

	@FXML
	private TextField txtAlbum;

	@FXML
	private RadioButton RBpunk;

	@FXML
	private TextField txtDirImagen;

	@FXML
	private TextField txtAnio;

	@FXML
	private TextField txtURL;

	@FXML
	private TextField txtArtista;

	@FXML
	void CargarCaratula(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Imagen");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));

		// Obtener la imagen seleccionada
		File imgFile = fileChooser.showOpenDialog(aplicacion.getPrimaryStage());

		// Mostar la imagen
		if (imgFile != null) {
			Image image = new Image("file:" + imgFile.getAbsolutePath());
			IMVcaratula.setImage(image);
		}

	}

	@FXML
	void GenerarCodigo(ActionEvent event) {

		String codigo = aplicacion.generarCodigo();

		txtCodigo.setText(codigo);

	}

	@FXML
	void GuardarCancion(ActionEvent event) {

		String nombre = txtNombCancion.getText();
		String album = txtAlbum.getText();
		String URL = txtURL.getText();
		String artista = txtArtista.getText();
		String codigo = txtCodigo.getText();

		String genero;

		if (RBreggaeton.isSelected()) {
			genero = "reggeaton";
		} else if (RBrock.isSelected()) {
			genero = "rock";
		} else if (RBpop.isSelected()) {
			genero = "pop";
		} else if (RBpunk.isSelected()) {
			genero = "punk";
		} else {
			genero = "electronica";
		}

		if (!(nombre.equals("") && album.equals("") && URL.equals("") && artista.equals("") && codigo.equals("")
				&& genero.equals(""))) {
			aplicacion.crearCancion(nombre, album, URL, artista, codigo, genero);
		} else {
			mostrarMensajeError("Hay campos sin completar");
		}

	}

	@FXML
	void Devolver(ActionEvent event) {

		aplicacion.devolverInicio();

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
