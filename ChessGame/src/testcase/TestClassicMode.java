package testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPlayer;
import chessGame.ClassicMode;
import chessGame.GameMode;
import chessGame.RankScoringMode;

public class TestClassicMode {
	
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	private GameMode mode = new ClassicMode();

	@Test
	public void testAddScore() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		int[] scoreRelated={100, 0};
		mode.addScore(p1, scoreRelated);
		int result = p1.getPlayerScore();
		assertEquals(0, result);
	}	
	
	//test isEndGame
	@Test
	public void testIsEndGameNoWinner(){
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = mode.isEndGame();
		assertEquals(false, result);
	}
	
	@Test
	public void testIsEndGameHasWinner(){
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		boolean result = mode.isEndGame();
		assertEquals(true, result);
	}
	
	//test print Result
	@Test
	public void testPrintResultPlayer1Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		mode.isEndGame();
		String winner = mode.printResult(p1, p2);
		assertEquals("a"+ " is the winner!", winner);
	}
	
	@Test
	public void testPrintResultPlayer2Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d1");
		mode.isEndGame();
		String winner = mode.printResult(p1, p2);
		assertEquals("b"+ " is the winner!", winner);
	}
	
}
