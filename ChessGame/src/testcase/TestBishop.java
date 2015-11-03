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
import chessGame.Bishop;
import junit.framework.TestCase;

public class TestBishop extends TestCase{
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
	//Test case: test for Player 1 bishop move to current position, bishop c1->c1
	public void testPlayer1BishopMoveToCurrentPos() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		boolean moveResult = bishopAtc1.isValidMove("c1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's top left move, bishop c3->a5
	public void testPlayer1BishopTopLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		
		boolean moveResult = bishopAtc1.isValidMove("a5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's top right move, bishop c3->e5
	public void testPlayer1BishopTopRightMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		
		boolean moveResult = bishopAtc1.isValidMove("e5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's bottom left move, bishop e5->c3
	public void testPlayer1BishopBottomLeftMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("e5");
		
		boolean moveResult = bishopAtc1.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's bottom right move, bishop a5->c3
	public void testPlayer1BishopBottomRightMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("a5");
		
		boolean moveResult = bishopAtc1.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, c1->a3 and b2 blocked
	public void testPlayer1BishopBlockedMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		Bishop bishopAtc1 = new Bishop(player1, "c1");
		boolean moveResult = bishopAtc1.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's invalid move, c1->b6
	public void testPlayer1BishopInvalidMove() {
		ChessPlayer player1 = new ChessPlayer("John", 1);
		ChessPlayer player2 = new ChessPlayer("John", 2);
		cms.initializeChessPieces(player1, player2);
		
		Bishop bishopAtc1 = new Bishop(player1, "c1");
		boolean moveResult = bishopAtc1.isValidMove("b6");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testBishopGetScore() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 1), null);
		int score = bishop.getScore();
		assertEquals(score, 30);
	}
	
	@Test
	public void testPlayer1PrintBishop() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 1), null);
		String stringResult = bishop.toString();
		assertEquals(stringResult, "B");
	}
	
	@Test
	public void testPlayer2PrintBishop() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 2), null);
		String stringResult = bishop.toString();
		assertEquals(stringResult, "b");
	}
}
