package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.Bishop;
import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Knight;
import chessGame.Pawn;
import junit.framework.TestCase;

public class TestKnight extends TestCase{
	private ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
	
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
	//Test case: test for Player 1 knight move to current position, knight b1->c3
	public void testPlayer1KnightMoveToCurrentPos() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		boolean moveResult = knightAtb1.isValidMove("b1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 knight's move, knight b1->c3
	public void testPlayer1KnightVerticalMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		boolean moveResult = knightAtb1.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's move, knight b3->d4
	public void testPlayer1KnightHorizontalMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		knightAtb1.updatePosition("b3");
		
		boolean moveResult = knightAtb1.isValidMove("d4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's move, b6->a8
	public void testPlayer1KnightCaptureEnemy() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		knightAtb1.updatePosition("b6");
		
		boolean moveResult = knightAtb1.isValidMove("a8");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's capturing own, b1->d2
	public void testPlayer1KnightCaptureOwn() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		boolean moveResult = knightAtb1.isValidMove("d2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 knight invalid move, b1->b3
	public void testPlayer1KnightInvalidMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece knightAtb1 = cms.getChessPiece("b1");
		boolean moveResult = knightAtb1.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testKnightGetScore() {
		Knight knight = new Knight(new ChessPlayer("John", 1), null);
		int score = knight.getScore();
		assertEquals(score, 20);
	}
	
	@Test
	public void testPlayer1PrintKnight() {
		Knight knight = new Knight(new ChessPlayer("John", 1), null);
		String stringResult = knight.toString();
		assertEquals(stringResult, "N");
	}
	
	@Test
	public void testPlayer2PrintKnight() {
		Knight knight = new Knight(new ChessPlayer("John", 2), null);
		String stringResult = knight.toString();
		assertEquals(stringResult, "n");
	}
}
