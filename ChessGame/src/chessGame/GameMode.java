package chessGame;

public interface Result{
	public String getResult(ChessPlayer player1, ChessPlayer player2);
        public boolean isEndGame();
        public void addScore(ChessPlayer player);
}
