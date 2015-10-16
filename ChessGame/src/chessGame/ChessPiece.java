package chessGame;

public abstract class ChessPiece {

	private String position;
	private ChessPlayer player;
	
	public ChessPiece(ChessPlayer player, String position){
		this.player=player;
		this.position=position;
	}
	
	public ChessPlayer getPlayer() {
		return this.player;
	}
	
	public abstract boolean moveIsAvailable(String moveTo);

	public String getPosition() {
		return this.position;
	}
	
	public void updatePosition(String move){
		this.position = move;
	}
	
}
