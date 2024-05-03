package MyGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class EasyModeController {

	@FXML
	public AnchorPane root;
	@FXML
	public ImageView imageView,hideImage;
	@FXML
	public TextField txtAnswer;
	@FXML
	public TextField player;
	@FXML
	public Text lblLevelCount;
	@FXML
	public Text lblLevel;
	@FXML
	public Text playerComment;
	@FXML
	public Text lblRemainingTime;
	@FXML
	public Text lblRemainingTimeCount;
	@FXML
	public Text txtComment;
	@FXML
	public Text playerScore;
	@FXML
	public Text levelScore,pScore;
	@FXML
	public Button btnNext;
	@FXML
	public Button btnSubmit;
	@FXML
	public Button mainMenubtn;
	@FXML
	public Button otherBtnNext;

	@FXML
	public Label lblAnswer;

	public int levelCount = 0;
	public int sendLevelCount;
	public int solution;
	int timeCount;
	boolean status = false;
	int score1 = 0;
	int score2 = 0;


	@FXML
	private MediaView mediaView;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;


	public void initialize() throws IOException, JSONException {


		loadQuestion();

		lblLevel.setText("Question Format ");
		lblLevelCount.setText("");
		btnNext.setText("Let's Play");
		txtAnswer.setVisible(false);
		lblAnswer.setVisible(false);
		lblRemainingTime.setVisible(false);
		lblRemainingTimeCount.setVisible(false);
		txtComment.setVisible(false);
		btnSubmit.setVisible(false);
		otherBtnNext.setVisible(false);
		playerComment.setVisible(false);
		hideImage.setVisible(false);
		pScore.setVisible(false);
		player.setVisible(false);

	}
	public void btnNextLevel(ActionEvent actionEvent) throws IOException, JSONException {
		txtAnswer.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.matches("\\d*")) return;
			txtAnswer.setText(newValue.replaceAll("[^\\d]", ""));
		});

		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();

		txtAnswer.setVisible(true);
		lblAnswer.setVisible(true);
		lblRemainingTime.setVisible(true);
		lblRemainingTimeCount.setVisible(true);
		txtComment.setVisible(false);
		btnSubmit.setVisible(true);
		btnNext.setVisible(false);
		otherBtnNext.setVisible(false);
		playerComment.setVisible(false);
		pScore.setVisible(true);

		levelCount +=1;
		lblLevel.setText("");
		lblLevelCount.setText("Level :  " + levelCount);
		btnNext.setText("Next");
		System.out.println("level Count :   " +levelCount);

		score2=0;
		levelScore.setText("Level Score  :  " +score2);

		if (levelCount == 11) {
			player.setVisible(true);
			imageView.setVisible(false);
			btnNext.setVisible(false);
			txtAnswer.setVisible(false);
			lblAnswer.setVisible(false);
			lblRemainingTime.setVisible(false);
			lblRemainingTimeCount.setVisible(false);
			lblLevelCount.setVisible(false);
			lblRemainingTime.setVisible(false);
			playerScore.setVisible(false);
			levelScore.setVisible(false);
			txtComment.setVisible(false);
			btnSubmit.setVisible(false);
			otherBtnNext.setVisible(true);
			playerComment.setVisible(true);
			hideImage.setVisible(true);
			pScore.setVisible(false);

			playerComment.setText("Your Score :  " +score1);

			file = new File("src/main/resources/MyGame/Footages/levelCompleted.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();
		}

		LevelTimer(levelCount, true);

		try{
			sendLevelCount = levelCount - 1;
			saveAnswer(sendLevelCount);
		} catch (RuntimeException e){

		}

	}


	public int loadQuestion() throws JSONException, IOException {
		JSONObject apiCaller = APILoaderController.callAPI();
		Image image = new Image(apiCaller.getString("question"));
		imageView.setImage(image);

		int sol = Integer.parseInt(String.valueOf(apiCaller.getInt("solution")));
		System.out.println("solution : " +sol);
		solution = sol;

		return solution;

	}

	public int btnSubmitOnAction () throws JSONException, IOException {


		int ans = Integer.parseInt(txtAnswer.getText());

		if (ans == solution  ){

			pScore.setVisible(true);
			btnNext.setVisible(true);
			System.out.println("Answer is correct :" +solution);
			txtComment.setVisible(true);
			txtComment.setText("Congratulations!!");
			btnSubmit.setVisible(false);
			lblAnswer.setVisible(false);
			txtAnswer.setVisible(false);
			playerComment.setVisible(false);

			file = new File("src/main/resources/MyGame/Footages/correctAnswer.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

			TimerStop(true);

		}else {
			pScore.setVisible(true);
			txtComment.setVisible(true);
			txtComment.setText("Wrong Answer, Try again..");
			System.out.println("Wrong Answer, try again." +ans);
			txtAnswer.clear();

			file = new File("src/main/resources/MyGame/Footages/wrongAnswer.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

			score1 = score1-10;
			score2 = score2-10;

			levelScore.setText("Level Score  :  " + score2);
			return score1;
		}
		score1 = 100 + score1;
		playerScore.setText(String.valueOf(score1));
		score2 = 100+score2;
		levelScore.setText("Level Score:  " +score2);
		score2=0;
		return score1;
	}


	private void saveAnswer(int levelCount) {
		String ans = txtAnswer.getText();
		int answer = Integer.parseInt(ans);
		System.out.println("Answer :  " +answer);
		System.out.println("Solution :  " +solution);
		System.out.println("Level count from :  " +levelCount);

		try {
			System.out.println("Next Level");
			TimerStop(false);
			loadQuestion();
			txtAnswer.clear();
			txtAnswer.requestFocus();
		} catch (Exception e) {
			System.out.println("problem have: " + e);
			e.printStackTrace();
		}
	}
	private void Timer (int time, int lvlCount) throws IOException {
		timeCount = time;
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				lblRemainingTimeCount.setText(String.valueOf(timeCount));
				timeCount--;
				if (timeCount == -1) {
					timer.cancel();

					score1 = 0 + score1;
					playerScore.setText(String.valueOf(score1));

					pScore.setVisible(true);
					btnNext.setVisible(true);
					btnSubmit.setVisible(false);
					lblAnswer.setVisible(false);
					txtAnswer.setVisible(false);


					saveAnswer(levelCount);
				} else if (status) {
					timer.cancel();
				}
			}
		} ;
		timer.scheduleAtFixedRate(timerTask, 1000,1000);
	}
	private void TimerStop(boolean isIt) {
		status = isIt;
	}
	private void LevelTimer(int level , boolean status) throws IOException  {
		if (level == 1) {
			Timer (120, level);
		} else if (level == 2) {
			Timer (110, level);
			TimerStop(true);
		} else if (level == 3) {
			Timer (100, level);
			TimerStop(true);
		} else if (level == 4) {
			TimerStop(true);
			Timer (90, level);
			TimerStop(true);
		} else if (level == 5) {
			Timer (80, level);
			TimerStop(true);
		} else if (level == 6) {
			Timer (70, level);
			TimerStop(true);
		} else if (level == 7) {
			Timer (60, level);
			TimerStop(true);
		} else if (level == 8) {
			Timer (55, level);
			TimerStop(true);
		} else if (level == 9) {
			Timer (50, level);
			TimerStop(true);
		} else if (level == 10) {
			Timer (45, level);
			TimerStop(true);
		} else if(level == 11) {
			Timer (1000, level);
			TimerStop(true);
		}else  {
			Timer (0, level);
			TimerStop(status);
		}
		TimerStop(false);
	}

	public void menuBtnOnAction (ActionEvent event) {
		Stage stage = (Stage) mainMenubtn.getScene().getWindow();
		stage.close();
		MenuFromGameGUI();

		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();
	}

	public void MenuFromGameGUI() {
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
	public void OtherNextBtnOnAction(ActionEvent event) {



		if (player.getText().isBlank()){
			txtComment.setVisible(true);
			txtComment.setText("Please enter your name!");

			file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();
		}else {
			file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
			media = new Media(file.toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			mediaPlayer.play();

			setHighScore();
			Stage stage = (Stage) otherBtnNext.getScene().getWindow();
			stage.close();
			GameOverUI();
		}



	}

	public void GameOverUI() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("gameOverUI.fxml"));
			Scene scene = new Scene(fxmlLoader.load(), 920, 580);

			Stage gameStage = new Stage();
			gameStage.setTitle("Game Over");
			gameStage.setScene(scene);
			gameStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}




	public void setHighScore() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		String score = playerScore.getText();
		String playerName = player.getText();

		String insertFields = "INSERT INTO easymodescore(score, pname) VALUES ('";
		String insertValues =  score + "','" + playerName+"')";
		String insertRegister = insertFields + insertValues;
		try {
			Statement statement = connectDB.createStatement();
			statement.executeUpdate(insertRegister);
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}


}


