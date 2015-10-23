package chessGame;

public class ChessPlayer {

	private String name;
	private int id;
	private int playerScore;
	private int chessPiece;

	public ChessPlayer(String playerName,int id) {
		this.name=playerName;
		this.id=id;
		playerScore=0;
		chessPiece=16;
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
		chessPiece--;
	}
	
	@Override
	public String toString(){
		return name;
	}

	public int getPiece() {
		return this.chessPiece;
	}

}
