/**
 * @author
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Bishop;
import chessGame.King;
import chessGame.Knight;
import chessGame.Pawn;
import chessGame.Queen;
import chessGame.Rook;
import chessGame.GameMode;
import chessGame.ScoringMode;
import junit.framework.TestCase;

public class TestScoringMode extends TestCase{
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	private GameMode mode = new ScoringMode();
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() {}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	public void testAddScore() {
		ChessPlayer player=new ChessPlayer("John", 1);
		GameMode mode = new ScoringMode();
		int[] scoreRelated={10, 0};
		mode.addScore(player, scoreRelated);
		assertEquals(10,player.getPlayerScore());	
	}	
	
	//test print Result
	@Test
	public void testPrintResultPlayer1Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		int[] scoreRelated={100, 0};
		mode.addScore(p1, scoreRelated);
		String winner = mode.printResult(p1, p2);
		assertEquals(winner,"a" + " is the winner!" + "\n" + "winner's score: 100");
	}
	
	@Test
	public void testPrintResultPlayer2Win() {
		ChessPlayer p1=new ChessPlayer("a", 0);
		ChessPlayer p2=new ChessPlayer("b", 1);
		int[] scoreRelated={100, 0};
		mode.addScore(p2, scoreRelated);
		String winner = mode.printResult(p1, p2);
		assertEquals(winner,"b"+ " is the winner!" + "\n" + "winner's score: 100");
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