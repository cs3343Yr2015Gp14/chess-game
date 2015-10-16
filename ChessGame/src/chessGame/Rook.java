package chessGame;

public class Rook extends ChessPiece {

	/**
	 * 
	 * @param id
	 */
	public Rook(String id) {
		// TODO - implement Rook.Rook
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param move
	 */
	public boolean moveIsAvailable(String move) {
		// TODO - implement Rook.moveIsAvailable
		throw new UnsupportedOperationException();
		
		//a1a2 vertical move
		if((int)position.charAt(0)==(int)move.charAt(1))
			if((int)position.charAt(1)-(int)move.charAt(2)>0)
				int k=(int)position.charAt(1)-(int)move.charAt(2);
				for(int i=0;i<k;i++)
					.getChessPiece(nearest position);//need to implement in chessMonitoringSystem
				//compare whether you can move there
			else if ((int)position.charAt(1)-(int)move.charAt(2)<0)
				int k=(int)position.charAt(2)-(int)move.charAt(1);
				for(int i=0;i<k;i++)
					.getChessPiece(nearest position);//need to implement in chessMonitoringSystem
				//compare whether you can move there
			else// dont move the chessPiece
				return false;
		
		//a1b1 horizontal move
		if((int)position.charAt(1)==(int)move.charAt(2))
			if((int)position.charAt(0)-(int)move.charAt(1)>0)
				int k=(int)position.charAt(0)-(int)move.charAt(1);
				for(int i=0;i<k;i++)
					.getChessPiece(nearest position);//need to implement in chessMonitoringSystem
				//compare whether you can move there
			else if ((int)position.charAt(0)-(int)move.charAt(1)<0)
				int k=(int)position.charAt(1)-(int)move.charAt(0);
				for(int i=0;i<k;i++)
					.getChessPiece(nearest position);//need to implement in chessMonitoringSystem
				//compare whether you can move there
			else// dont move the chessPiece
				return false;

		else
			return false;
			
			
		
		
		
		
	}

}
