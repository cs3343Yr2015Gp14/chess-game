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
import chessGame.King;
import chessGame.Pawn;
import junit.framework.TestCase;

public class TestKing extends TestCase{
	private ChessMonitoringSystem cms = ChessMonitoringSystem.getInstance();

    /**
     * Sets up the ChessMonitoringSystem
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
	//Test case: test Player 1 for King move to current position, king d3->d4
	public void testPlayer1KingMoveToCurrentPos() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		boolean moveResult = kingAtd1.isValidMove("d1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test Player 1 for King's vertical move, king d3->d4
	public void testPlayer1KingVerticalMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		kingAtd1.updatePosition("d3");
		
		boolean moveResult = kingAtd1.isValidMove("d4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's horizontal move, king d3->c3
	public void testPlayer1KingHorizontalMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd2 = cms.getChessPiece("d1");
		kingAtd2.updatePosition("d3");
		
		boolean moveResult = kingAtd2.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's diagonal move to top left, d3->c4
	public void testPlayer1KingTopLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		kingAtd1.updatePosition("d3");
		
		boolean moveResult = kingAtd1.isValidMove("c4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's capturing own, d1->c2
	public void testPlayer1KingCaptureOwn() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		boolean moveResult = kingAtd1.isValidMove("c2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 King's capturing enemy, d6->d7
	public void testPlayer1KingCaptureEnemy() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		kingAtd1.updatePosition("d6");

		boolean moveResult = kingAtd1.isValidMove("d7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 King's invalid move, d1->c6
	public void testPlayer1KingInvalidMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece kingAtd1 = cms.getChessPiece("d1");
		boolean moveResult = kingAtd1.isValidMove("c6");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPlayer1PrintKing() {
		King king = new King(new ChessPlayer("John", 1), null);
		String stringResult = king.toString();
		assertEquals(stringResult, "K");
	}
	
	@Test
	public void testPlayer2PrintKing() {
		King king = new King(new ChessPlayer("John", 2), null);
		String stringResult = king.toString();
		assertEquals(stringResult, "k");
	}
}
