package MyGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
	public static String LoggedUsername;
	@FXML //For the Cancel Button
	private Button CancelButton;
	@FXML //For the Login message
	private Label loginMessageLabel;
	@FXML //For the Login image
	private ImageView loginImageView;
	@FXML //For the login button
	private Button loginButton;
	@FXML
	private TextField loginUsername;
	@FXML
	private PasswordField loginPassword;
	@FXML
	private Hyperlink registerHyperLink;
	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;


	@Override // to get image from...
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File loginFile = new File("src/main/resources/MyGame/Images/2.png");
		Image loginImage = new Image(loginFile.toURI().toString());
		loginImageView.setImage(loginImage);
	}

	public void loginButtonOnAction(ActionEvent event) { //to display login status
		if (!loginUsername.getText().isBlank() && !loginPassword.getText().isBlank()) { // or if (loginUsername.getText().isBlank()==false && loginPassword.getText().isBlank()==false)
			validateLogin();
		} else {
			loginMessageLabel.setText("Please enter Username and Password."); //if it is invalid login
		}
	}


	public void backButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) CancelButton.getScene().getWindow();
		stage.close();
		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		LoginMenuGUI();
	}

	public void LoginMenuGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("loginMainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 500, 500);

			Stage loginStage = new Stage();
			loginStage.setTitle("Login Menu");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	public void registerHyperLinkOnAction(ActionEvent event) { // to go to the Game
		Stage stage = (Stage) registerHyperLink.getScene().getWindow();
		stage.close();

		loginUI();
	}

	public void loginUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("register.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage gameStage = new Stage();
			gameStage.setTitle("Register");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	public void validateLogin() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		String verifyLogin = "select count(1) from user_login where username " +
				"='" + loginUsername.getText() + "'AND password='" + loginPassword.getText() + "'";

		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin); //Execute what are having in the verifyLogin.

			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					//loginMessageLabel.setText("Successfully logged in!!");
					Stage stage = (Stage) loginButton.getScene().getWindow();
					stage.close();
					file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
					media = new Media(file.toURI().toString());
					mediaPlayer = new MediaPlayer(media);
					mediaView.setMediaPlayer(mediaPlayer);
					mediaPlayer.play();
					UserMenu();

				} else {
					loginMessageLabel.setText("Invalid Login, Please try again.");

					file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
					media = new Media(file.toURI().toString());
					mediaPlayer = new MediaPlayer(media);
					mediaView.setMediaPlayer(mediaPlayer);
					mediaPlayer.play();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	public void UserMenu() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("mainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage registerStage = new Stage();
			registerStage.setTitle("CISGame");
			registerStage.setScene(scene);
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

}