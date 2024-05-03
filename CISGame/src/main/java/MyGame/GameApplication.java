package MyGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
	public static void main(String[] args) {

		launch();

	}

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("loginMainMenu.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 500, 500);


		/*FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("hardMode.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 920, 580);*/
		stage.setTitle("CISGame");
		stage.setScene(scene);
		stage.show();
	}
}