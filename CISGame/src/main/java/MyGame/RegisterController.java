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
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

	@FXML
	private ImageView registerImage;
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField signUpUsername;
	@FXML
	private PasswordField signUpPassword;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Label signUpMessageLabel;
	@FXML
	private Button backButton;
	@FXML
	private Button signUpButton;
	@FXML
	private Hyperlink loginHyperLink;
	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;


	@Override // to get image from...
	public void initialize(URL url, ResourceBundle resourceBundle) {
		File registerFile = new File("src/main/resources/MyGame/Images/registerImg.png");
		Image regiterImg = new Image(registerFile.toURI().toString());
		registerImage.setImage(regiterImg);
	}


	public void registerButtonOnAction(ActionEvent event) {
		if (firstName.getText().isBlank() || lastName.getText().isBlank() || signUpUsername.getText().isBlank() || signUpPassword.getText().isBlank() || confirmPassword.getText().isBlank()) {
			signUpMessageLabel.setText("Please fill following fields.");

			file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

		} else if (!signUpPassword.getText().equals(confirmPassword.getText())) {
			signUpMessageLabel.setText("Password does not match.");

			file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

		} else {

			file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

			registerUser();

			Stage stage = (Stage) signUpButton.getScene().getWindow();
			stage.close();
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("login.fxml"));
				Scene scene = new Scene(fxmlLoader.load(), 920, 580);

				Stage registerStage = new Stage();
				registerStage.setTitle("Log in");
				registerStage.setScene(scene);
				registerStage.show();
			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
			}

		}
	}

	public void backButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.close();
		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
		LoginMainMenuGUI();
	}

	public void LoginMainMenuGUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("loginMainMenu.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 500, 500);

			Stage loginStage = new Stage();
			loginStage.setTitle("CIS GAME");
			loginStage.setScene(scene);
			loginStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void loginHyperLinkOnAction(ActionEvent event) {
		Stage stage = (Stage) loginHyperLink.getScene().getWindow();
		stage.close();
		loginUI();
	}

	public void loginUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("login.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage gameStage = new Stage();
			gameStage.setTitle("LOGIN");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}


	public void registerUser() {

		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		String firstname = firstName.getText();
		String lastname = lastName.getText();
		String username = signUpUsername.getText();
		String password = signUpPassword.getText();

		String insertFields = "insert into user_login (firstname,lastname,username,password) values ('";
		String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
		String insertRegister = insertFields + insertValues;

		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(insertRegister);

			signUpMessageLabel.setText("User has been registered successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}


	}


}
