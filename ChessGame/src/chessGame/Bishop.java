package chessGame;

public class Bishop extends ChessPiece {
	private final int score=30;

	public Bishop(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	@Override
	public boolean isValidMove(String moveTo) {
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		// TO-DO: Exception own chess
		
		if(position==moveTo)
			return false;
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null || 
				CMS.getChessPiece(moveTo).getPlayer()!=this.player)
		{
			int numOfMoves=0;
			ChessPiece tempChess=null;
			boolean isBlocked=false;
			
			//Character.toChars(x)
			//Integer.toString(i)
			
			int xPosDiff = position.charAt(0)-moveTo.charAt(0);
			int yPosDiff = position.charAt(1)-moveTo.charAt(1);
			
			if(Math.abs(yPosDiff)==Math.abs(xPosDiff))
			{
				numOfMoves = Math.abs(xPosDiff);
				
				// top left corner
				if(xPosDiff>0 && yPosDiff<0)	
				{
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)-i)+(char)(position.charAt(1)+i));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// lower left corner
				if(xPosDiff>0 && yPosDiff>0)	
				{
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)-i)+(char)(position.charAt(1)-i));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// top right corner
				if(xPosDiff<0 && yPosDiff<0)	
				{
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)+i)+(char)(position.charAt(1)+i));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// lower right corner
				if(xPosDiff<0 && yPosDiff>0)	
				{
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)+i)+(char)((position.charAt(1)-i)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				
				if(isBlocked==false)
					return true;
				else
					return false;
			}

		}//end of most outer loop
		return false;
		
	}//end of method

	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString(){
		if (player.getPlayerId()==1)
			return "B";
		else if (player.getPlayerId()==2)
			return "b";
		else
			return null;
	}

}
