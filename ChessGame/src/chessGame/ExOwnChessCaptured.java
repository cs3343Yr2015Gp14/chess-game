package chessGame;

public class ExOwnChessCaptured extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5667168514872321613L;
	public ExOwnChessCaptured() {super("You cannot capture your own chessPiece!");}
}
