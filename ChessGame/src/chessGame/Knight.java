package chessGame;

public class Knight extends ChessPiece {

	public Knight(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean moveIsAvailable(String moveTo) {
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null || 
				CMS.getChessPiece(moveTo).getPlayer()!=this.player)
		{
			if (Math.abs(moveTo.charAt(0)-position.charAt(0))==2 &&
					Math.abs(moveTo.charAt(1)-position.charAt(1))==1)
				return true;
			else if (Math.abs(moveTo.charAt(0)-position.charAt(0))==1 &&
					Math.abs(moveTo.charAt(1)-position.charAt(1))==2)
				return true;
		}
		return false;
	}

}