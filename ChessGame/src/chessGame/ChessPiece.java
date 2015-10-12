package chessGame;

public abstract class ChessPiece {

	private String position;
	private ChessPlayer player;

	public ChessPlayer getPlayer() {
		return this.player;
	}
	
	public abstract boolean moveIsAvailable(String move);
	
	public String getPosition() {
		return this.position;
	}

	public void updatePosition(String move){
		if( moveIsAvailable(move) == true){
			this.position = move;
		}
		
	}

}
