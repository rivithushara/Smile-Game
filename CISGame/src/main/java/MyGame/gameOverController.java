package MyGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class gameOverController implements Initializable {
	@FXML
	public Button gameOverMenubtn;
	@FXML
	private MediaView mediaView;


	/**
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		File file = new File("src/main/resources/MyGame/Footages/GameOverVid.mp4");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();

	}
	public void gameOverenuBtnOnAction (ActionEvent event) {
		Stage stage = (Stage) gameOverMenubtn.getScene().getWindow();
		stage.close();
		//Platform.exit();
		MenuFromGameOver();
	}

	public void MenuFromGameOver() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("mainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage loginStage = new Stage();
			loginStage.setTitle("Main Menu");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


}
