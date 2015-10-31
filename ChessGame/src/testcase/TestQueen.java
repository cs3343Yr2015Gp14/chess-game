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
import junit.framework.TestCase;

public class TestQueen extends TestCase{
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
	//Test case: test Player 1 for Queen move to current position, e3->e5
	public void testPlayer1QueenMoveToCurrentPos() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("e1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test Player 1 for Queen's vertical move, e3->e5
	public void testPlayer1QueenVerticalUpwardMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		
		boolean moveResult = queenAte1.isValidMove("e5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's vertical move, e5->e3
	public void testPlayer1QueenVerticalDownwardMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e5");
		
		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's horizontal move, e3->h3
	public void testPlayer1QueenHorizontalLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		
		boolean moveResult = queenAte1.isValidMove("h3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's horizontal move, h3->e3
	public void testPlayer1QueenHorizontalRightMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("h3");
		
		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's diagonal move to top left, e3->c5
	public void testPlayer1QueenTopLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		
		boolean moveResult = queenAte1.isValidMove("c5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's diagonal move to top right, e3->g5
	public void testPlayer1QueenTopRightMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		
		boolean moveResult = queenAte1.isValidMove("g5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's diagonal move to bottom left, g5->e3
	public void testPlayer1QueenBottomLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("g5");
		
		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's diagonal move to top left, c5->e3
	public void testPlayer1QueenBottomRightMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("c5");
		
		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing enemy, e3->a7
	public void testPlayer1QueenCaptureEnemy() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		
		boolean moveResult = queenAte1.isValidMove("a7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing own, e1->d2
	public void testPlayer1QueenCaptureOwn() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("d2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test Player 1 for Queen's capturing own, e1->c3 and d2 is blocked
	public void testPlayer1QueenBlockedMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("c3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test Player 1 for Queen's invalid move, e1->d6
	public void testPlayer1QueenInvalidMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("d6");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintQueen() {
		Queen queen = new Queen(new ChessPlayer("John", 1), null);
		String stringResult = queen.toString();
		assertEquals(stringResult, "Q");
	}
	
	@Test
	public void testPlayer2PrintQueen() {
		Queen queen = new Queen(new ChessPlayer("John", 2), null);
		String stringResult = queen.toString();
		assertEquals(stringResult, "q");
	}
}
