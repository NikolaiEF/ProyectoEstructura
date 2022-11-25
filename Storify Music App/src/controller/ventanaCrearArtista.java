package controller;

import javax.swing.JOptionPane;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ventanaCrearArtista {

	Main aplicacion;

	 public void setAplicacion(Main aplicacion) {
			this.aplicacion = aplicacion;
		}

	 @FXML
	    private RadioButton RBreggaeton;

	    @FXML
	    private RadioButton RBrock;

	    @FXML
	    private RadioButton RBpop;

	    @FXML
	    private ToggleGroup GeneroArt;

	    @FXML
	    private ToggleGroup tipoArtista;

	    @FXML
	    private TextField txtCodArtista;

	    @FXML
	    private RadioButton RBsolista;

	    @FXML
	    private RadioButton RBpunk;

	    @FXML
	    private TextField txtNombreArt;

	    @FXML
	    private TextField txtNacionalidad;

	    @FXML
	    private RadioButton RBduo;

	    @FXML
	    private RadioButton RBelectronica;


	    @FXML
	    void GuardarArtista(ActionEvent event) {

	    	String nombre = txtNombreArt.getText();
	    	String nacionalidad= txtNacionalidad.getText();
	    	String codigo = txtCodArtista.getText();
	    	String genero;
	    	boolean duo;

	    	if(RBduo.isSelected()){
	    		 duo = true;
	    	}else{
	    		 duo =false;
	    	}

	    	if(RBreggaeton.isSelected()){
	    		genero = "reggeaton";
	    	}else if (RBrock.isSelected()){
	    		genero = "rock";
	    	}else if (RBpop.isSelected()){
	    		genero = "pop";
	    	}else if (RBpunk.isSelected()){
	    		genero = "punk";
	    	}else{
	    		genero = "electronica";
	    	}

	    	if(!tipoArtista.getSelectedToggle().equals(null)&&!GeneroArt.getSelectedToggle().equals(null)&&!txtCodArtista.getText().equals("")
	    			&& !txtNacionalidad.getText().equals("") && !txtNombreArt.getText().equals("")){
	    		aplicacion.crearArtistaFull(nombre, nacionalidad, codigo, genero, duo);
	    	}else{
	    		JOptionPane.showMessageDialog(null, "falta informacion");
	    	}

	    }

	    @FXML
	    void Devolver(ActionEvent event) {

	    	aplicacion.devolverInicio();

	    }


}
