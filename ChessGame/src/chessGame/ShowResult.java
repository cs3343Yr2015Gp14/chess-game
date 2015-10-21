package chessGame;

public class ShowResult implements Command{

	@Override
	public boolean execute(ChessPlayer player1, ChessPlayer player2,
			String related) {
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		cms.getGameResult(player1, player2);
		return false;
	}

}
