package chessGame;

public class ChessPlayer {

	private String name;
	private int id;
	private int playerScore;

	public ChessPlayer(String playerName,int id) {
		this.name=playerName;
		this.id=id;
		playerScore=0;
	}
	
	public void addScore(int score){
		playerScore+=score;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}

	public int getPlayerId(){
		return id;
	}
	
	@Override
	public String toString(){
		return name;
	}

}
