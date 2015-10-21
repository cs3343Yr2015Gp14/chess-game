package chessGame;

public class ClassicResult implements Result{
	
	@Override
	public String getResult(ChessPlayer player1, ChessPlayer player2) {
		// TODO Auto-generated method stub
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		ChessPlayer winner = cms.getWinner();
		return winner.toString() + " is the winner!";
	}
}
