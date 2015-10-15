package chessGame;

public class King extends ChessPiece {

	public King(ChessPlayer player, String position) {
		super(player, position);	
	}

	public boolean moveIsAvailable(String move) {	
		
		// Exception out of the board scope 
		
		if(this.position relative to position)
		
			//a1a2 vertical move
			(int)position.charAt(0)==(int)move.charAt(1)
			Math.abs((int)position.charAt(1)-(int)move.charAt(2))==1
			//a1b1 horizontal move
			Math.abs((int)position.charAt(0)-(int)move.charAt(1))==1
			(int)position.charAt(1)==(int)move.charAt(2)
			//a1b2 diangonal
			Math.abs((int)position.charAt(1)-(int)move.charAt(2))==1
			Math.abs((int)position.charAt(0)-(int)move.charAt(1))==1
			
		return true;
		
		
		
		throw new UnsupportedOperationException();
	}

}