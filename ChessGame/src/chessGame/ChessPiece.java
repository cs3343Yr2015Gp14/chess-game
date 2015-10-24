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
	
	public abstract boolean isValidMove(String moveTo);

	public String getPosition() {
		return this.position;
	}
	
	public void updatePosition(String move){
		this.position = move;
	}
	
	public abstract int getScore();
	
//	@Override
//	public abstract String toString();

	public abstract int getRank();
}
