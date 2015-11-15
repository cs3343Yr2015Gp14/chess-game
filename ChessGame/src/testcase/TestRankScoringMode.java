package testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPlayer;
import chessGame.GameMode;
import chessGame.RankScoringMode;
import chessGame.ScoringMode;

public class TestRankScoringMode {
	
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	private GameMode mode = new RankScoringMode();
	
	@Test
	public void testAddLittleScore() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		int[] scoreRelated={100, 0};
		mode.addScore(p1, scoreRelated);
		int result = p1.getPlayerScore();
		assertEquals(result,80);
	}	
	
	@Test
	public void testAddSameScore() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		int[] scoreRelated={100, 2};
		mode.addScore(p1, scoreRelated);
		int result = p1.getPlayerScore();
		assertEquals(100, result);
	}	
	
	@Test
	public void testAddHigherScore() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		int[] scoreRelated={100, 1};
		mode.addScore(p1, scoreRelated);
		int result = p1.getPlayerScore();
		assertEquals(120, result);
	}	
	
	//test print Result
	@Test
	public void testPrintResultPlayer1Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		int[] scoreRelated={100, 0};
		mode.addScore(p1, scoreRelated);
		String winner = mode.printResult(p1, p2);
		assertEquals(winner,"a"+ " is the winner!" + "\n" + "winner's score: 80");
	}
	
	@Test
	public void testPrintResultPlayer2Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		int[] scoreRelated={100, 0};
		mode.addScore(p2, scoreRelated);
		String winner = mode.printResult(p1, p2);
		assertEquals(winner,"b"+ " is the winner!" + "\n" + "winner's score: 80");
	}
	
	@Test
	public void testPrintResultDraw() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		String winner = mode.printResult(p1, p2);
		assertEquals(winner,"Draw!");
	}
	
	//test isEndGame
	@Test
	public void testisEndGameKingCaptured() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		boolean result = mode.isEndGame();
		assertEquals(true, result);
	}
	
	@Test
	public void testisEndGameNoKingCaptured() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = mode.isEndGame();
		assertEquals(false, result);
	}
}
