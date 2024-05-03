module cisgame {
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;

	requires java.sql;
	requires mysql.connector.j;
	requires java.json;
	requires java.rmi;
	requires java.desktop;
	requires javafx.media;

	opens MyGame; //to javafx.fxml;
	//exports MyGame;
}