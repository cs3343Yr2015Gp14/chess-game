package chessGame;

public class King extends ChessPiece {
	
	
	public King(ChessPlayer player, String position) {
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
			// a1a2 vertical move
			if((int)position.charAt(0)==(int)moveTo.charAt(1) && 
					Math.abs((int)position.charAt(1)-(int)moveTo.charAt(1))==1)
				return true;
			// a1b1 horizontal move
			else if((int)position.charAt(1)==(int)moveTo.charAt(2) && 
					Math.abs((int)position.charAt(0)-(int)moveTo.charAt(0))==1)
				return true;
			// a1b2 diagonal move
			else if(Math.abs((int)position.charAt(1)-(int)moveTo.charAt(1))==1 &&
					Math.abs((int)position.charAt(0)-(int)moveTo.charAt(0))==1)
				return true;
		} 
		return false;

	}

}