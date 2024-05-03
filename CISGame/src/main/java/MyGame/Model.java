package MyGame;

public class Model {

	private String playerName;
	private Integer playerScore;

	public Model(String playerName, Integer playerScore) {
		this.playerName = playerName;
		this.playerScore = playerScore;
	}

	public String getPlayerName() {
		return playerName;
	}
	public Integer getPlayerScore() {
		return playerScore;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setPlayerScore(Integer playerScore) {
		this.playerScore = playerScore;
	}
}
