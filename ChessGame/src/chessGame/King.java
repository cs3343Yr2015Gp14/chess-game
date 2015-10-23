package chessGame;

public class King extends ChessPiece {
	private final int score=0;
	private final int rank=6;
	
	public King(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	@Override
	public boolean moveIsAvailable(String moveTo) {	
		 
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null || 
				CMS.getChessPiece(moveTo).getPlayer()!=this.player)
		{
			// a1a2 vertical move
			if((int)position.charAt(0)==(int)moveTo.charAt(0) && 
					Math.abs((int)position.charAt(1)-(int)moveTo.charAt(1))==1)
				return true;
			// a1b1 horizontal move
			else if((int)position.charAt(1)==(int)moveTo.charAt(1) && 
					Math.abs((int)position.charAt(0)-(int)moveTo.charAt(0))==1)
				return true;
			// a1b2 diagonal move
			else if(Math.abs((int)position.charAt(1)-(int)moveTo.charAt(1))==1 &&
					Math.abs((int)position.charAt(0)-(int)moveTo.charAt(0))==1)
				return true;
		} 
		
		return false;
	}

	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString(){
		if (player.getPlayerId()==1)
			return "K";
		else if (player.getPlayerId()==2)
			return "k";
		else
			return null;
	}

	@Override
	public int getRank() {
		return rank;
	}

}
