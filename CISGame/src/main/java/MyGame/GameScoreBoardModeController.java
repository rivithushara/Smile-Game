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


public class GameScoreBoardModeController {

	@FXML //For the ### button
	private Button EasyM,NormalM,HardM;
	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;




	public void easyModePlayOnAction(ActionEvent event) { // to go to the Game
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) EasyM.getScene().getWindow();
		stage.close();
		easy();
	}

	public void easy() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("scoreBoardEasy.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 675);

			Stage gameStage = new Stage();
			gameStage.setTitle("Game mode :  Easy");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void normalModePlayOnAction(ActionEvent event) { // to go to the Login GUI
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) NormalM.getScene().getWindow();
		stage.close();
		normal();
	}

	public void normal() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("scoreBoardNormal.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 675);

			Stage loginStage = new Stage();
			loginStage.setTitle("Game mode :  Normal");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void hardModePlayOnAction(ActionEvent event) { // to terminate the program
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) HardM.getScene().getWindow();
		stage.close();
		hard();
	}

	public void hard() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("scoreBoardHard.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 675);

			Stage loginStage = new Stage();
			loginStage.setTitle("Game mode :  Hard");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


}