package chessGame;

public class Knight extends ChessPiece {

	private final int score=20;
	
	public Knight(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean isValidMove(String moveTo) {
		// TO-DO: add Exception out of the board scope 
		// throw new UnsupportedOperationException();
		
		ChessMonitoringSystem CMS = ChessMonitoringSystem.getInstance();
		if(CMS.getChessPiece(moveTo)==null || 
				CMS.getChessPiece(moveTo).getPlayer()!=this.player)
		{
			int xPosDiff = moveTo.charAt(0)-position.charAt(0);
			int yPosDiff = moveTo.charAt(1)-position.charAt(1);
			if (Math.abs(xPosDiff)==2 && Math.abs(yPosDiff)==1) //vertical move
				return true;
			else if (Math.abs(xPosDiff)==1 && Math.abs(yPosDiff)==2) //horizontal move
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
			return "N";
		else if (player.getPlayerId()==2)
			return "n";
		else
			return null;
	}

}
