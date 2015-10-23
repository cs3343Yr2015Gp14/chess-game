package chessGame;

public class ChessPlayer {

	private String name;
	private int id;
	private int playerScore;
	private int numOfPieces;

	public ChessPlayer(String playerName,int id) {
		this.name=playerName;
		this.id=id;
		playerScore=0;
		numOfPieces=16;
	}
	
	public void addScore(double score){
		playerScore+=score;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}

	public int getPlayerId(){
		return id;
	}
	
	public void lossPiece(){
		numOfPieces--;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public int getPiece() {
		return this.numOfPieces;
	}

}
