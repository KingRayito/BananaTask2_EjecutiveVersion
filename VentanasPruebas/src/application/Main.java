package application;
	
import clasesbasicas.*;
import clasesgenerales.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loaderInicio = new FXMLLoader(getClass().getResource("Inicio.fxml"));
		Parent layoutInicio = loaderInicio.load();
		Scene sceneInicio = new Scene(layoutInicio,200,200);
		
		FXMLLoader loaderInicioSesion = new FXMLLoader(getClass().getResource("InicioSesion.fxml"));
		Parent layoutInicioSesion = loaderInicioSesion.load();
		Scene sceneInicioSecion = new Scene(layoutInicioSesion,300,250);
		
		InicioController  inicioController = (InicioController) loaderInicio.getController();
		inicioController.setSceneInicioSesion(sceneInicioSecion);
		
		
		primaryStage.setTitle("BananaTask2");
		primaryStage.setScene(sceneInicio);
		primaryStage.show();
		
		ListaIntegrantes integrantes = new ListaIntegrantes();
		integrantes.agregarIntegrante(new Integrante("Bastian", "1905", true));
		integrantes.agregarIntegrante(new Integrante("Tifa", "1905", true));
		integrantes.agregarIntegrante(new Integrante("Felipe", "1905", true));
		System.out.println("Se agregaron datos iniciales...");
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
