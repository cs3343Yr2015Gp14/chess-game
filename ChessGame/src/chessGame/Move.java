package chessGame;

public class Move implements Command {

	@Override
	public boolean execute(ChessPlayer player, ChessPlayer anotherPlayer, String related) {
		ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
		String[] position = related.split(":");
		boolean success=chessMonitoringSystem.moveChessPiece(player,position[0],position[1]);
		return success;
	}

}
