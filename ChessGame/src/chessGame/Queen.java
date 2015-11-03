package chessGame;

public class Queen extends ChessPiece {
	private final int score=90;
	
	public Queen(ChessPlayer player, String position) {
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
			
			// a1a2 vertical move
			if(position.charAt(0)==moveTo.charAt(0))
			{
				// move down
				if(position.charAt(1)-moveTo.charAt(1)>0)	
				{
					numOfMoves=(position.charAt(1)-moveTo.charAt(1));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+position.charAt(0)+(char)(position.charAt(1)-i));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// move up
				if(position.charAt(1)-moveTo.charAt(1)<0)
				{
					numOfMoves=moveTo.charAt(1)-position.charAt(1);
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+position.charAt(0)+(char)(position.charAt(1)+i));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}		
				if(isBlocked==false)
					return true;
				else
					return false;
			}
			// a1b2 horizontal move
			if(position.charAt(1)==moveTo.charAt(1))
			{
				// move left
				if(position.charAt(0)-moveTo.charAt(0)>0)	
				{
					numOfMoves=(position.charAt(0)-moveTo.charAt(0));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)-i)+position.charAt(1));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// move right
				if(position.charAt(0)-moveTo.charAt(0)<0)
				{
					numOfMoves=moveTo.charAt(0)-position.charAt(0);
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)+i)+position.charAt(1));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}	
				if(isBlocked==false)
					return true;
				else
					return false;
			}
			
			if(Math.abs(position.charAt(1)-moveTo.charAt(1))==
					Math.abs(position.charAt(0)-moveTo.charAt(0)))
			{
				// top left corner
				if(position.charAt(0)-moveTo.charAt(0)>0 &&
						position.charAt(1)-moveTo.charAt(1)<0)	
				{
					numOfMoves=(position.charAt(0)-moveTo.charAt(0));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)-i)+(char)((position.charAt(1)+i)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// lower left corner
				if(position.charAt(0)-moveTo.charAt(0)>0 &&
						position.charAt(1)-moveTo.charAt(1)>0)	
				{
					numOfMoves=(position.charAt(0)-moveTo.charAt(0));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)-i)+(char)((position.charAt(1)-i)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// top right corner
				if(position.charAt(0)-moveTo.charAt(0)<0 &&
						position.charAt(1)-moveTo.charAt(1)<0)	
				{
					numOfMoves=(moveTo.charAt(0)-position.charAt(0));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(""+(char)(position.charAt(0)+i)+(char)((position.charAt(1)+i)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// lower right corner
				if(position.charAt(0)-moveTo.charAt(0)<0 &&
						position.charAt(1)-moveTo.charAt(1)>0)	
				{
					numOfMoves=(position.charAt(1)-moveTo.charAt(1));
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
			return "Q";
		else if (player.getPlayerId()==2)
			return "q";
		else
			return null;
	}

}
