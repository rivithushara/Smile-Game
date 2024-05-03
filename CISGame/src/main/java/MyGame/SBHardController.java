package MyGame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SBHardController implements Initializable {

	@FXML
	private Button highscoreBackButton;

	@FXML
	private TextField searchPlayer;
	@FXML
	private MediaView mediaView;
	@FXML
	private TableView<Model> scoreTable;
	@FXML
	private TableColumn<Model, String> colName;
	@FXML
	private TableColumn<Model, Integer> colScore;
	private File file ;
	private Media media;
	private MediaPlayer mediaPlayer;

	ObservableList<Model> searchModelObservableList = FXCollections.observableArrayList();

	public void highscoreBackButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) highscoreBackButton.getScene().getWindow();
		stage.close();
		file = new File("src/main/resources/MyGame/Footages/btnClick1.wav");
		media = new Media(file.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		mediaPlayer.play();

		MenuFromHSGUI();
	}

	public void MenuFromHSGUI() {
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

	/**
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		//SQL query - execute in the backend
		String playerScoreQuery = "SELECT score,pname FROM hardmodescore";

		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput = statement.executeQuery(playerScoreQuery);

			while (queryOutput.next()){

				Integer playersScore = queryOutput.getInt("score");
				String playerName = queryOutput.getString("pname");

				//Populate the ObservableList
				searchModelObservableList.add(new Model(playerName, playersScore));
			}

			//PropertyValueFactory corresponds to the Model fields
			//The table column is the one annotate above
			colName.setCellValueFactory(new PropertyValueFactory<>("playerName"));
			colScore.setCellValueFactory(new PropertyValueFactory<>("playerScore"));

			scoreTable.setItems(searchModelObservableList);

			//Initial filtered list
			FilteredList<Model> filteredData = new FilteredList<>(searchModelObservableList, b-> true);

			searchPlayer.textProperty().addListener((observable, oldValue, newValue)->{
				filteredData.setPredicate(Model ->{

					//If no search value the display all records or whatever records it current have...
					if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
						return true;
					}
					String searchKeyword = newValue.toLowerCase();

					if(Model.getPlayerName().toLowerCase().indexOf(searchKeyword) > -1){
						return true; //means we found a match in PlayerName
					} else if (Model.getPlayerScore().toString().indexOf(searchKeyword) > -1) {
						return true; //means we found a match in PlayerScore
					} else {
						return false; // no matching results
					}
				});
			});

			SortedList<Model> sortedData = new SortedList<>(filteredData);

			//Bind sorted result with TableView
			sortedData.comparatorProperty().bind(scoreTable.comparatorProperty());

			//Apply filtered and sorted data to the TableView
			scoreTable.setItems(sortedData);

		}catch (SQLException e){
			Logger.getLogger(SBEasyController.class.getName()).log(Level.SEVERE,null,e);
			e.printStackTrace();
		}
	}
}
