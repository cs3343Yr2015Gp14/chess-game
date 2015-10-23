package chessGame;

public class Rook extends ChessPiece {
	private final int score=40;
	private final int rank=4;
	
	public Rook(ChessPlayer player, String position) {
		super(player, position);	
	}

	@Override
	public boolean moveIsAvailable(String moveTo) {
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
			if((int)position.charAt(0)==(int)moveTo.charAt(0))
			{
				// move down
				if((int)position.charAt(1)-(int)moveTo.charAt(1)>0)	
				{
					numOfMoves=((int)position.charAt(1)-(int)moveTo.charAt(1));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(position.charAt(0)+String.valueOf((position.charAt(1)-i)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// move up
				if((int)position.charAt(1)-(int)moveTo.charAt(1)<0)
				{
					numOfMoves=(int)moveTo.charAt(1)-(int)position.charAt(1);
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece(position.charAt(0)+String.valueOf((position.charAt(1)+i)));//wrong formatting
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
			if((int)position.charAt(1)==(int)moveTo.charAt(1))
			{
				// move left
				if((int)position.charAt(0)-(int)moveTo.charAt(0)>0)	
				{
					numOfMoves=((int)position.charAt(0)-(int)moveTo.charAt(0));
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece((char)((int)position.charAt(0)-i)+Integer.toString(position.charAt(1)));//wrong formatting
						if(tempChess!=null)
							isBlocked=true;
					}	
				}
				// move right
				if((int)position.charAt(0)-(int)moveTo.charAt(0)<0)
				{
					numOfMoves=(int)moveTo.charAt(0)-(int)position.charAt(0);
					//check any pieces in the middle (position to moveTo)
					for(int i=1;i<numOfMoves;i++)
					{
						tempChess=CMS.getChessPiece((char)((int)position.charAt(0)+i)+Integer.toString(position.charAt(1)));//wrong formatting
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
			return "R";
		else if (player.getPlayerId()==2)
			return "r";
		else
			return null;
	}

	@Override
	public int getRank() {
		return rank;
	}

}
