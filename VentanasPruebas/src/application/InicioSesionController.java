package application;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.Scene;

public class InicioSesionController {
	@FXML
	private JFXTextField identificadorField;
	@FXML
	private JFXPasswordField contrasenaField;
	@FXML
	private Scene sceneMenuAdmin;
	@FXML
	private Scene sceneMenuNormal;

    public void setSceneMenuAdmin(Scene scene) {
        sceneMenuAdmin = scene;
    }
    
    public void setSceneMenuNormal(Scene scene) {
        sceneMenuNormal = scene;
    }
    
    
}
