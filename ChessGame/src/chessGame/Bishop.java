package chessGame;

public class Bishop extends ChessPiece {
	private final int score=0;

	public Bishop(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean moveIsAvailable(String moveTo) {
		// TODO - implement Bishop.moveIsAvailable
		throw new UnsupportedOperationException();
	}

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