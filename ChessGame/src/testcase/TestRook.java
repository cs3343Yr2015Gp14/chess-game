/**
 * @author PP
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Pawn;
import chessGame.Queen;
import chessGame.Rook;
import junit.framework.TestCase;

public class TestRook extends TestCase{
	ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();
	ChessPlayer player1 = new ChessPlayer("John", 1);
	ChessPlayer player2 = new ChessPlayer("John", 2);
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() {cms.initializeChessPieces(player1, player2);}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	//Test case: test for Player 1 rook move to current position, a3->a6
	public void testPlayer1RookMoveToCurrentPos() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		boolean moveResult = rookAta1.isValidMove("a1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's vertical move, a3->a6
	public void testPlayer1RookVerticalUpMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		boolean moveResult = rookAta1.isValidMove("a6");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's vertical move, a1->a6->a3
	public void testPlayer1RookVerticalDownMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a6");
		
		boolean moveResult = rookAta1.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's vertical move, a1->a6, a5 blocked, a6->a3
	public void testPlayer1RookVerticalDownBlockedMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a6");
		ChessPiece rookAth1 = cms.getChessPiece("h1");
		rookAth1.updatePosition("a5");
		
		boolean moveResult = rookAta1.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a1->h3->a3
	public void testPlayer1RookHorizontalLeftMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("h3");
		
		boolean moveResult = rookAta1.isValidMove("a3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a1->a3, g3 blocked, h3->a3
	public void testPlayer1RookHorizontalLeftBlockedMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("h3");
		
		ChessPiece rookAth1 = cms.getChessPiece("h1");
		rookAth1.updatePosition("g3");
		
		boolean moveResult = rookAta1.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a3->h3
	public void testPlayer1RookHorizontalRightMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		boolean moveResult = rookAta1.isValidMove("h3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's horizontal move, a1->a3, g3 blocked, a3->h3
	public void testPlayer1RookHorizontalRightBlockedMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		ChessPiece rookAth1 = cms.getChessPiece("h1");
		rookAth1.updatePosition("g3");
		
		boolean moveResult = rookAta1.isValidMove("h3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's blocked move, a1->a3, a2 blocked
	public void testPlayer1RookVerticalUpBlockedMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		boolean moveResult = rookAta1.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's capturing opponent's piece, a3->a7
	public void testPlayer1RookCaptureEnemy() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		boolean moveResult = rookAta1.isValidMove("a7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 rook's capturing own piece, a1->a2
	public void testPlayer1RookCaptureOwn() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		boolean moveResult = rookAta1.isValidMove("a2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 rook's invalid move, a1->b6
	public void testPlayer1RookInvalidMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		boolean moveResult = rookAta1.isValidMove("b6");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testRookGetScore() {
		Rook rook = new Rook(new ChessPlayer("John", 1), null);
		int score = rook.getScore();
		assertEquals(score, 40);
	}
	
	@Test
	public void testPlayer1PrintRook() {
		Rook rook = new Rook(new ChessPlayer("John", 1), null);
		String stringResult = rook.toString();
		assertEquals(stringResult, "R");
	}
	
	@Test
	public void testPlayer2PrintRook() {
		Rook rook = new Rook(new ChessPlayer("John", 2), null);
		String stringResult = rook.toString();
		assertEquals(stringResult, "r");
	}
	
	@Test
	public void testOtherPrintRook() {
		Rook rook = new Rook(new ChessPlayer("John", 3), null);
		String stringResult = rook.toString();
		assertEquals(stringResult, null);
	}
}
