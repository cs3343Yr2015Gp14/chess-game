package chessGame;

public class StartGame implements Command{

	@Override
	public boolean execute(ChessPlayer player1, ChessPlayer player2, String mode) {
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		Result result;
		if (mode.equals("1"))
			result = new ClassicResult();
		else
			result = new ScoringResult();
		cms.startGame(player1, player2, result);
		return false;
	}
	
}
