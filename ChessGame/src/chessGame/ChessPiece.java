package chessGame;

public abstract class ChessPiece {

	private String position;
	private ChessPlayer player;

	public ChessPlayer getPlayer() {
		return this.player;
	}

	public String getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param move
	 */
	public abstract boolean moveIsAvailable(String move);

	/**
	 * 
	 * @param move
	 */
	public void updatePosition(String move) {
		// TODO - implement ChessPiece.updatePosition
		throw new UnsupportedOperationException();
	}

}