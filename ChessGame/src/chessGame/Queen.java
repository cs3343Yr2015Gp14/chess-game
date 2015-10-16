package chessGame;

public class Queen extends ChessPiece {
	private final int score=0;
	
	public Queen(ChessPlayer player, String position) {
		super(player, position);	
	}
	
	public boolean moveIsAvailable(String moveTo) {
		// TODO - implement Queen.moveIsAvailable
		throw new UnsupportedOperationException();
	}

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