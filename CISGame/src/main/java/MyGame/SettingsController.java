package MyGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;


public class SettingsController {

	@FXML //For the ### button
	private Button settingBackButton;
	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;

	public void settingBackButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) settingBackButton.getScene().getWindow();
		stage.close();
		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		MenuFromSettingGUI();
	}

	public void MenuFromSettingGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("mainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage loginStage = new Stage();
			loginStage.setTitle("CIS GAME");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
}
