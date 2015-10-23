package chessGame;

public class Pawn extends ChessPiece {
	private static final char initialYPos1 = '2';
	private static final char initialYPos2 = '7';
	private final int score=10;
	private final int rank=1;
	
	public Pawn(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean moveIsAvailable(String moveTo) {
		
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null)
		{
			//special move at initial position
			if (position.charAt(1)==initialYPos1 ||
					position.charAt(1)==initialYPos2)
			{
				if (moveTo.charAt(0)==position.charAt(0) &&
						Math.abs(moveTo.charAt(1)-position.charAt(1))==2)
					return true;
			}
			
			//other moves
			if (moveTo.charAt(0)==position.charAt(0) && 
					Math.abs(moveTo.charAt(1)-position.charAt(1))==1)
				return true;
		}
		else 
		{
			//pawn can only capture pieces in the front diagonally
			if (CMS.getChessPiece(moveTo).getPlayer()!=this.player) 
			{
				int playerId = this.player.getPlayerId();
				int xPosDiff = moveTo.charAt(0)-position.charAt(0);
				int yPosDiff = moveTo.charAt(1)-position.charAt(1);
				boolean isValidPosDiff = Math.abs(xPosDiff)==1 && Math.abs(yPosDiff)==1; //x and y position diff. in 1
				if (isValidPosDiff)
				{
					if ((playerId==1 && yPosDiff>0) ||	//player1's pawn: new yPos always larger  
							(playerId==2 && yPosDiff<0))	//player2's pawn: new yPos always smaller
						return true;
				}
			}
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

	@Override
	public int getRank() {
		return rank;
	}
}