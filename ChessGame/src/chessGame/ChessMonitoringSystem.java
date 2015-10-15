package chessGame;

public class ChessMonitoringSystem {

	private static ChessPiece[] allChessPieces;
	private static ChessMonitoringSystem instance;

	private ChessMonitoringSystem() {
		// TODO - implement ChessMonitoringSystem.ChessMonitoringSystem
		throw new UnsupportedOperationException();
	}

	public static ChessMonitoringSystem getInstance() {
		return instance;
	}

	public void initializeChessboard() {
		// TODO - implement ChessMonitoringSystem.initializeChessboard
		throw new UnsupportedOperationException();
	}

	public void initializeChessPieces(ChessPlayer player1, ChessPlayer player2) {
		// TODO - implement ChessMonitoringSystem.initializeChessPieces
		allChessPieces = new ChessPiece[32];
		ChessPlayer[] chessPlayerList = {player1, player2};
		
		int initialPosition = 1;
		int pawnPos = 2;
		
		for (int i = 0; i<2; i++)
		{
			allChessPieces[i*16] = new Rook(chessPlayerList[i], "a"+initialPosition);
			allChessPieces[i*16+1] = new Knight(chessPlayerList[i], "b"+initialPosition);
			allChessPieces[i*16+2] = new Bishop(chessPlayerList[i], "c"+initialPosition);
			allChessPieces[i*16+3] = new King(chessPlayerList[i], "d"+initialPosition);
			allChessPieces[i*16+4] = new Queen(chessPlayerList[i], "e"+initialPosition);
			allChessPieces[i*16+5] = new Bishop(chessPlayerList[i], "f"+initialPosition);
			allChessPieces[i*16+6] = new Knight(chessPlayerList[i], "g"+initialPosition);
			allChessPieces[i*16+7] = new Rook(chessPlayerList[i], "h"+initialPosition);
			
			//8 pawns		
			int xPosCharCode = 97;
			for (int j = 0; j<8; j++)
			{
				String xPawnPos= ""+(char)xPosCharCode; //x-coordinate of pawns' position
				allChessPieces[i*16+8+j] = new Pawn(chessPlayerList[i], xPawnPos+pawnPos);
				xPosCharCode++;
			}
			
			pawnPos = 7; //inverted y-coordinate for Pawns
			initialPosition = 8; //invert y-coordinate for oponent's chess pieces
		}
		
		throw new UnsupportedOperationException();
	}

	public void showAllChessPiecesPosition() {
		// TODO - implement ChessMonitoringSystem.showAllChessPiecesPosition
		String [][] chessPiecesPosition = new String[8][8]; //virtual chess board
		String tempPos = null;
		int xPosInNum = 0;
		int yPosInNum = 0;
		
		//initialize chess board
		for (int i = 0; i<8; i++)
			for (int j = 0; j<8; j++)
				chessPiecesPosition[i][j] = "O"; //or "\u25A1", a white square
		
		for (ChessPiece c: allChessPieces)
		{
			tempPos = c.getPosition();
			xPosInNum = (int)tempPos.charAt(0)-96;
			yPosInNum = (int)tempPos.charAt(1);
			chessPiecesPosition[yPosInNum][xPosInNum] = c.toString();
		}
		
		System.out.println("  a b c d e f g h");

		for (int i = 0; i<8; i++)
		{
			System.out.print(i+1+" ");
			for (int j = 0; j<8; j++)
			{
				System.out.print(chessPiecesPosition[i][j]);
			}
			System.out.println();
		}
		
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param move
	 * @param playerId
	 * Chesspiece target;
		
	
	 */
	 
	private boolean isDestinationOccupied(String move) {
		for(Chesspiece c: allChessPieces)
			if(c.getPosition().equals(move))
				return true;
			else
				return false;
	}
	
	private boolean isChessCaptured(Chesspiece target, String move) {
		// TODO - implement ChessMonitoringSystem.chessPieceIsCaptured
		for(Chesspiece c: allChessPieces)
			if(c.getPosition().equals(move))
				if(target.getPlayer()!=c.getPlayer())
					return true;
				else
					return false;
		
		throw new UnsupportedOperationException();
	}
	
	
	public void moveChessPiece(String input, String move, ChessPlayer player) {
		// TODO - implement ChessMonitoringSystem.moveChessPiece
		
		for(Chesspiece c : allChessPieces) {
			if(c.position.equals(input))
				target = c;
		}
		//error catching
		if(target == null)
			system.out.println("Chesspiece not found!");
		else if(!target.getPlayer().equals(player))
          		system.out.println("Selected piece does not belong to you!");
		else if(target.moveIsAvailable(move))
			if(!isDestinationOccupied(move))
          			target.updatePosition(move);
          		else if(isChessCaptured(Chesspiece target, String move)) {
          			removeChessPiece(move);
          			target.updatePosition(move);	
          		}
        	else
          		system.out.println("The move is invalid.");
          		
          		
		throw new UnsupportedOperationException();
	}

	

	/**
	 * 
	 * @param position
	 */
	private void removeChessPiece(String position) {
		// TODO - implement ChessMonitoringSystem.removeChessPiece
		for(Chesspiece c: allChessPieces)
			if(c.getPosition().equals(position)) {
				if(c.getClass().equals("King"))
					checkGameResult(c);
				
				allChessPieces.remove(c);
			}
				
		
		throw new UnsupportedOperationException();
	}

	public void checkGameResult(Chesspiece king) {
		// TODO - implement ChessMonitoringSystem.checkGameResult

		chessPlayer loser = king.getPlayer();
		chessPlayer winner;
		
		for(chessPlayer o: chessPlayersList)
			if(o!=loser)
				winner = o;
				
		System.out.printf("Player %s won!", winner.toString());

		throw new UnsupportedOperationException();
	}

}
