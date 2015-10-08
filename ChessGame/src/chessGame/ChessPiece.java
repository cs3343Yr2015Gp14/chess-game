package chessGame;

public abstract class ChessPiece {

	private String position;
	private ChessPlayer player;

	public ChessPlayer getPlayer() {
		return player;

	}

	public abstract String[] getAvailableMoves();

	public void updatePosition() {
		// TODO - implement ChessPiece.updatePosition
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param moves
	 */
	public boolean movesIsAvailable(String moves) {
		// TODO - implement ChessPiece.movesIsAvailable
		throw new UnsupportedOperationException();
	}

}