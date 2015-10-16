package chessGame;

public class ChessPlayer {

	private String name;
	private int id;
	private int playerScore;

	public ChessPlayer(String playerName,int id) {
		this.name=playerName;
		this.id=id;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}

	public int getPlayerId(){
		return id;
	}
	
	public String getPlayerName(){
		return name;
	}

}
