package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

		aplicacion.crearUsuario(nombre, apellido, clave, correo);
	}

	@FXML
	void Atras(ActionEvent event) {

		aplicacion.devolverLogin();

	}

}
