package chessGame;

public interface Command{
	public boolean execute(ChessPlayer player1, ChessPlayer player2, String related);
}
