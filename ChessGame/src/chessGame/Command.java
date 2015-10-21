package chessGame;

public interface Command{
	public boolean execute(ChessPlayer player, String relatedA, String relatedB);
}
