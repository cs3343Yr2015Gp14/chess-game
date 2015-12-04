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
	//Test case: test for Player 1 bishop move to current position, bishop c1->c1
	public void testPlayer1BishopMoveToCurrentPos() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		boolean moveResult = bishopAtc1.isValidMove("c1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's top left move, bishop c3->a5
	public void testPlayer1BishopTopLeftMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		
		boolean moveResult = bishopAtc1.isValidMove("a5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's top right move, bishop c3->e5
	public void testPlayer1BishopTopRightMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		
		boolean moveResult = bishopAtc1.isValidMove("e5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's bottom left move, bishop e5->c3
	public void testPlayer1BishopBottomLeftMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("e5");
		
		boolean moveResult = bishopAtc1.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's bottom right move, bishop a5->c3
	public void testPlayer1BishopBottomRightMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("a5");
		
		boolean moveResult = bishopAtc1.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, c1->a3 and b2 blocked (top left)
	public void testPlayer1BishopTopLeftBlockedMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		boolean moveResult = bishopAtc1.isValidMove("a3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, e3->c1 and d2 blocked (lower left)
	public void testPlayer1BishopLowerLeftBlockedMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("e3");
//		System.out.println("bishopAtc1.getPosition(): "+bishopAtc1.getPosition());
		boolean moveResult = bishopAtc1.isValidMove("c1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, c1->e3 and d2 blocked (top right)
	public void testPlayer1BishoTopRightBlockedMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		boolean moveResult = bishopAtc1.isValidMove("e3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's blocked move, a3->c1 and b2 blocked (lower right)
	public void testPlayer1BishoLowerRightBlockedMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("a3");
		boolean moveResult = bishopAtc1.isValidMove("c1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's invalid move, c1->b6
	public void testPlayer1BishopInvalidMove() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		boolean moveResult = bishopAtc1.isValidMove("b6");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 bishop's capture enemy, c1->c3->g7
	public void testPlayer1BishopCaptureEnenmy() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		boolean moveResult = bishopAtc1.isValidMove("g7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 bishop's capture enemy, c1->c3->d2
	public void testPlayer1BishopCaptureOwn() {
		ChessPiece bishopAtc1 = cms.getChessPiece("c1");
		bishopAtc1.updatePosition("c3");
		boolean moveResult = bishopAtc1.isValidMove("d2");
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
	
	@Test
	public void testOtherPrintBishop() {
		Bishop bishop = new Bishop(new ChessPlayer("John", 3), null);
		String stringResult = bishop.toString();
		assertEquals(stringResult, null);
	}
}
