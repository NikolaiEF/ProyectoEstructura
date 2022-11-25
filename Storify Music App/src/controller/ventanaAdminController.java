package controller;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Artista;

public class ventanaAdminController {

		Main aplicacion;

		private ObservableList<Artista> listaArtistasData= FXCollections.observableArrayList();

		@FXML
	     private TableView<Artista> tablaArtistas;

	     @FXML
	     private TableColumn<String, Artista> columnNombreArt;

	     @FXML
	     private TableColumn<String, Artista> columnCodArt;




		public void setAplicacion(Main aplicacion) {
			this.aplicacion = aplicacion;
			tablaArtistas.getItems().clear();
			tablaArtistas.setItems(getListaArtistas());

		}


	 	private ObservableList<Artista> getListaArtistas() {

	 		listaArtistasData.addAll(aplicacion.obtenerArtista());

	 		return listaArtistasData;
		}


	 	@FXML
	 	void initialize() {
	 		this.columnCodArt.setCellValueFactory(new PropertyValueFactory<>("codigo"));
	 		this.columnNombreArt.setCellValueFactory(new PropertyValueFactory<>("nombre"));

	 	}

		@FXML
	    void crearArtista(ActionEvent event) {
	 		aplicacion.crearArt();

	    }

	    @FXML
	    void SubirCancion(ActionEvent event) {

	    	aplicacion.subirCancion();

	    }

	    @FXML
	    void Devolver(ActionEvent event) {

	    	aplicacion.devolverLogin();

	    }


}
