package chessGame;

public class Knight extends ChessPiece {

	private final int score=0;
	private final int rank=3;
	
	public Knight(ChessPlayer player, String position) {
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
			if (Math.abs(moveTo.charAt(0)-position.charAt(0))==2 &&
					Math.abs(moveTo.charAt(1)-position.charAt(1))==1)
				return true;
			else if (Math.abs(moveTo.charAt(0)-position.charAt(0))==1 &&
					Math.abs(moveTo.charAt(1)-position.charAt(1))==2)
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

	@Override
	public int getRank() {
		return rank;
	}
}