package chessGame;

public class RankScoringMode implements GameMode {

	@Override
	public String getResult(ChessPlayer player1, ChessPlayer player2) {
		ChessPlayer winner;
		int score1 = player1.getPlayerScore();
		int score2 = player2.getPlayerScore();
		if (score1 > score2)
			winner = player1;
		else if (score2 > score1)
			winner = player2;
		else
			return "Draw!";
		return winner.toString() + " is the winner!" + "\n" + "winner's score: " + winner.getPlayerScore();
	}

	@Override
	public boolean isEndGame() {
		ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
    	if (cms.isKingCaptured()!=null)
    		return true;
    	else
    		return false;
	}

	@Override
	public void addScore(ChessPlayer player, int[] scoreRelated) {
		// TODO Auto-generated method stub
		double score= scoreRelated[0];
		if (scoreRelated[1]==0){
			score = score * 0.8;
		}
		else if (scoreRelated[1]==1){
			score = score * 1.2;
		}
		player.addScore(score);
	}

}
