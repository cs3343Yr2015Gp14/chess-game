package chessGame;

public interface GameMode{
	public String getResult(ChessPlayer player1, ChessPlayer player2);
	public boolean isEndGame();
	public void addScore(ChessPlayer player, int[] scoreRelated);
}
