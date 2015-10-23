package chessGame;

public class ClassicMode implements GameMode{
	
	private ChessPlayer winner;
	
	@Override
	public String printResult(ChessPlayer player1, ChessPlayer player2) {
		return winner.toString() + " is the winner!";
	}

	@Override
	public boolean isEndGame() {
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
    	this.winner = cms.isKingCaptured();
    	if (winner!=null)
    		return true;
    	else
    		return false;
	}

	@Override
	public void addScore(ChessPlayer player, int[] scoreRelated) {
		player.addScore(0);
	}
}
