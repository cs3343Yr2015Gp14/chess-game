package chessGame;

public abstract class ChessPiece {

	private String position;
	private ChessPlayer player;

	public ChessPlayer getPlayer() {
		return this.player;
	}

	public String getPosition() {
		return this.position;
	}
	
	/*If get available move is needed
	public abstract String[] getAvailableMoves();
	I am not quite sure how it works...moveIsAvailable call getAvailableMovies() for checking the movie is available?
	So both is abstruct? As the function for getting different chess available moves are different......
	Or, Only IsAvailable(String move) is needed?
	*/
	/**
	 * 
	 * @param move
	 */
	public abstract boolean moveIsAvailable(String move);

	/**
	 * 
	 * @param move
	 */
	public void updatePosition(String move) {
		// TODO - implement ChessPiece.updatePosition
		throw new UnsupportedOperationException();
		boolean start = moveIsAvailable(move);
		try{
			if (start){
				this.position = move;
			}
			else{
				move = null;
				this.position = move;
			}
		}//Which class handle the unavailable move? chess controller? boolean updatePosition?
	}

}
