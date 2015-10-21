package chessGame;

public class SurrenderClassic implements Result{

	@Override
	public String getResult(ChessPlayer player1, ChessPlayer player2) {
		if (player1.getPiece() > player2.getPiece())
			return player1.toString() + " is the winner";
		else if (player2.getPiece() > player1.getPiece())
			return player2.toString() + " is the winner";
		else
			return "Draw!";
	}

}
