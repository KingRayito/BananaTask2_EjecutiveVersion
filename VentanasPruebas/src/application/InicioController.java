package application;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.stage.*;

public class InicioController {
	@FXML
	private Scene sceneInicioSesion;

    public void setSceneInicioSesion(Scene scene) {
        sceneInicioSesion = scene;
    }

    public void openSceneInicioSesion(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(sceneInicioSesion);
    }
}
