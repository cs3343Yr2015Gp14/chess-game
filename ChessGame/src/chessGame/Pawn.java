package chessGame;

public class Pawn extends ChessPiece {
	private static final char initialYPos1 = '2';
	private static final char initialYPos2 = '7';
	private final int score=10;
	private final int rank=1;
	
	public Pawn(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean isValidMove(String moveTo) {
		
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		boolean isSameXPos = moveTo.charAt(0)==position.charAt(0);
		int xPosDiff = moveTo.charAt(0)-position.charAt(0);
		int yPosDiff = moveTo.charAt(1)-position.charAt(1);
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		
		//pawn can only move forward
		if(CMS.getChessPiece(moveTo)==null)
		{
			if (isSameXPos && !isBlocked(moveTo) && isForwardMove(moveTo))
			{
				//special move: 2 grids forward at initial position
				if (position.charAt(1)==initialYPos1 || position.charAt(1)==initialYPos2)
				{
					if (Math.abs(yPosDiff)==2)
						return true;
				}
				
				//other moves: 1 grid forward
				if (Math.abs(yPosDiff)==1)
					return true;
			}
		}
		else 
		{
			//pawn can only capture pieces in the front diagonally
			if (CMS.getChessPiece(moveTo).getPlayer()!=this.player && isForwardMove(moveTo))
			{
				boolean isValidPosDiff = Math.abs(xPosDiff)==1 && Math.abs(yPosDiff)==1; //x and y position diff. in 1
				if (isValidPosDiff)
					return true;
			}
		}
		
		return false;
	}
	
	//pawn can only move forward
	private boolean isForwardMove(String moveTo) {
		int yPosDiff = moveTo.charAt(1)-position.charAt(1);
		int playerId = this.player.getPlayerId();
		
		if ((playerId==1 && yPosDiff>0) ||	//player1's pawn: new yPos always larger  
				(playerId==2 && yPosDiff<0))	//player2's pawn: new yPos always smaller
			return true;
		
		return false;
	}

	//check whether block by own piece or opponent's piece
	private boolean isBlocked(String moveTo) { 
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
		int yPosDiff = moveTo.charAt(1)-position.charAt(1);
		
		if (yPosDiff>1)
		{
			for (int i = 0; i<2; i++)
			{
				String tempPos = ""+position.charAt(0)+(String.valueOf(position.charAt(1))+i+1);
				if (cms.getChessPiece(tempPos)!=null)
					return true;
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