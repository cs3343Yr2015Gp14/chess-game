package chessGame;

public class King extends ChessPiece {
	private final int score=150;
	
	public King(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	@Override
	public boolean isValidMove(String moveTo) {	
		 
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null || 
				CMS.getChessPiece(moveTo).getPlayer()!=this.player)
		{
			int xPosDiff = position.charAt(0)-moveTo.charAt(0);
			int yPosDiff = position.charAt(1)-moveTo.charAt(1);
			// a1a2 vertical move
			if(position.charAt(0)==moveTo.charAt(0) && Math.abs(yPosDiff)==1)
				return true;
			// a1b1 horizontal move
			else if(position.charAt(1)==moveTo.charAt(1) && Math.abs(xPosDiff)==1)
				return true;
			// a1b2 diagonal move
			else if(Math.abs(yPosDiff)==1 && Math.abs(xPosDiff)==1)
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

}
