package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class UiApplication extends Application {

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() {
		applicationContext = new SpringApplicationBuilder(JavafxSpringBootApplication.class).run();
	}

	@Override
	public void start(Stage stage) {

		/*
		 * String javaVersion = System.getProperty("java.version"); String javafxVersion
		 * = System.getProperty("javafx.version"); Label l = new Label("Hello, JavaFX "
		 * + javafxVersion + ", running on Java " + javaVersion + "."); Scene scene =
		 * new Scene(new StackPane(l), 640, 480); stage.setScene(scene); stage.show();
		 */

		FlowPane noRaiz = new FlowPane();

		Scene minhaCena = new Scene(noRaiz, 300, 200);

		Button btn = new Button();

		btn.setText("Ola Mundo");

		noRaiz.getChildren().add(btn);

		btn.setOnAction((event) -> {
			
			Alert dialogoErro = new Alert(Alert.AlertType.NONE);
            dialogoErro.setTitle("Msg");
            dialogoErro.setHeaderText("Cabeçalho");
            dialogoErro.setContentText("Mensagem");
            dialogoErro.showAndWait();
		});
		
		stage.setScene(minhaCena);

		stage.show();

	}

	@Override
	public void stop() throws Exception {

		applicationContext.close();
		Platform.exit();
	}

}
