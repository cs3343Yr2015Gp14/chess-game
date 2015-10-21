package chessGame;

public class Move implements Command {

	@Override
	public boolean execute(ChessPlayer player, String relatedA, String relatedB) {
		ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
		boolean success=chessMonitoringSystem.moveChessPiece(player,relatedA,relatedB);
		return success;
	}

}
