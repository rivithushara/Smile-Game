package MyGame;

import javafx.application.Platform;
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


public class MainMenuController {

	@FXML //For the ### button
	private Button menuPlayButton,menuHighscoreButton,menuSettingButton,menuQuitButton,loginMenuLoginButton,loginMenuSignUpButton,loginMenuExitButton,logOutButton,aboutBackButton,menuAboutButton;
	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;

	public void linkPlayButtonOnAction(ActionEvent event) { // to go to the Game
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) menuPlayButton.getScene().getWindow();
		stage.close();
		GUI();
	}

	public void GUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameplayMode.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 500, 500);

			Stage gameStage = new Stage();
			gameStage.setTitle("Game Mode ");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void linkHSButtonOnAction(ActionEvent event) { // to go to the High score GUI
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) menuHighscoreButton.getScene().getWindow();
		stage.close();
		highScoreGUI();
	}

	public void highScoreGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameModeSB.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 500, 500);

			Stage highScoreStage = new Stage();
			highScoreStage.setTitle("Score Mode");
			highScoreStage.setScene(scene);
			highScoreStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void linkSettingButtonOnAction(ActionEvent event) { // to go to the Setting GUI
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) menuSettingButton.getScene().getWindow();
		stage.close();
		settingGUI();
	}

	public void settingGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("settings.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage settingStage = new Stage();
			settingStage.setTitle("Settings");
			settingStage.setScene(scene);
			settingStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void linkAboutButtonOnAction(ActionEvent event) { // to go to the Setting GUI
		file = new File("src/main/resources/MyGame/Footages/mainMenuClick.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) menuAboutButton.getScene().getWindow();
		stage.close();
		aboutGUI();
	}

	public void aboutGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("about.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage settingStage = new Stage();
			settingStage.setTitle("About");
			settingStage.setScene(scene);
			settingStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void logOutButtonOnAction(ActionEvent event) { // to terminate the program
		file = new File("src/main/resources/MyGame/Footages/exitBtn.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) logOutButton.getScene().getWindow();
		stage.close();

		LoginMenuGUI();
	}
	public void LoginMenuGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("loginMainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 500, 500);

			Stage gameStage = new Stage();
			gameStage.setTitle("Login Menu");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void linkQuitButtonOnAction(ActionEvent event) { // to terminate the program

		file = new File("src/main/resources/MyGame/Footages/exitBtn.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) menuQuitButton.getScene().getWindow();
		stage.close();

		Platform.exit();
	}


	public void menuLoginButtonOnAction(ActionEvent event) { // to go to the Game
		file = new File("src/main/resources/MyGame/Footages/btnClick2.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) loginMenuLoginButton.getScene().getWindow();
		stage.close();
		gameLoginGUI();
	}

	public void gameLoginGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage gameStage = new Stage();
			gameStage.setTitle("Login ");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void menuSignUpButtonOnAction(ActionEvent event) { // to go to the Login GUI
		file = new File("src/main/resources/MyGame/Footages/btnClick2.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) loginMenuSignUpButton.getScene().getWindow();
		stage.close();
		gameSignUPGUI();
	}

	public void gameSignUPGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("register.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage loginStage = new Stage();
			loginStage.setTitle("Sign in");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void menuExitButtonOnAction(ActionEvent event) { // to terminate the program
		file = new File("src/main/resources/MyGame/Footages/exitBtn.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) loginMenuExitButton.getScene().getWindow();
		stage.close();

		Platform.exit();
	}

	public void linkSignUpButtonOnAction(ActionEvent event) {
	}

	public void aboutBackButtonOnAction(ActionEvent event) {
		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		Stage stage = (Stage) aboutBackButton.getScene().getWindow();
		stage.close();
		MenuGUI();
	}

	public void MenuGUI() {
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