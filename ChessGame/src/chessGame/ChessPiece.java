package chessGame;

public abstract class ChessPiece {

	protected String position;
	protected ChessPlayer player;
	
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
