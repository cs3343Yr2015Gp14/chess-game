package chessGame;

public class Pawn extends ChessPiece {
	private static final int initialYPos1 = 2;
	private static final int initialYPos2 = 7;
	private final int score=0;
	
	public Pawn(ChessPlayer player, String position) {
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
			//special move at initial position
			if (position.charAt(1)==initialYPos1 ||
					position.charAt(1)==initialYPos2)
			{
				if (Math.abs(moveTo.charAt(1)-position.charAt(1))==2)
					return true;
			}
			
			//other moves
			if (Math.abs(moveTo.charAt(1)-position.charAt(1))==1) 
					return true;
		}
		
		return false;
	}
	
	public int getScore(){
		return score;
	}
	
	@Override
	public String toString(){
		if (player.getPlayerId()==1)
			return "P";
		else if (player.getPlayerId()==2)
			return "p";
		else
			return null;
	}
}