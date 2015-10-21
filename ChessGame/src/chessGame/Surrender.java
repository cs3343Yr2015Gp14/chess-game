package chessGame;

public class Surrender implements Command{

	@Override
	public boolean execute(ChessPlayer player1, ChessPlayer player2,
			String related) {
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		cms.surrender(player1, player2);
		return false;
	}

}
