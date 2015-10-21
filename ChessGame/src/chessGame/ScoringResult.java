package chessGame;

public class ScoringResult implements Result{

	@Override
	public String getResult(ChessPlayer player1, ChessPlayer player2) {
		// TODO Auto-generated method stub
		ChessPlayer winner;
		int score1 = player1.getPlayerScore();
		int score2 = player2.getPlayerScore();
		if (score1 > score2)
			winner = player1;
		else if (score2 > score1)
			winner = player2;
		else
			return "Draw!";
		return winner.toString() + "is the winner";
	}

}
