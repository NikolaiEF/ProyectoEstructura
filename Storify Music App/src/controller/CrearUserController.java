package controller;

import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CrearUserController {

	Main aplicacion;

	@FXML
	private PasswordField passContra;

	@FXML
	private TextField txtApellCrear;

	@FXML
	private TextField txtNomCrear;

	@FXML
	private TextField txtEmailCrear;

	public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;
	}

	@FXML
	void CrearUsuario(ActionEvent event) {
		String nombre = txtNomCrear.getText();
		String apellido = txtApellCrear.getText();
		String clave = passContra.getText();
		String correo = txtEmailCrear.getText();

	
			if (!(nombre.equals("") && apellido.equals("") && clave.equals("") && correo.equals(""))) {
				aplicacion.crearUsuario(nombre, apellido, clave, correo);
			}else {
				mostrarMensajeError("Hay campos sin completar");
			}

	}

	@FXML
	void Atras(ActionEvent event) {
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
