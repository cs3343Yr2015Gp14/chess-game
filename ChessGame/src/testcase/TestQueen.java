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
import chessGame.Knight;
import chessGame.Pawn;
import chessGame.Queen;
import junit.framework.TestCase;

public class TestQueen extends TestCase{
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
	//Test case: test Player 1 for Queen move to current position, e3->e5
	public void testPlayer1QueenMoveToCurrentPos() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("e1");
		assertEquals(moveResult, false);
	}

	@Test
	//Test case: test Player 1 for Queen's vertical move, e3->e5
	public void testPlayer1QueenVerticalUpwardMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("e5");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's vertical move, e5->e3
	public void testPlayer1QueenVerticalDownwardMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e5");

		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's horizontal move, e3->b3
	public void testPlayer1QueenHorizontalLeftMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("b3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's horizontal move, e3->h3
	public void testPlayer1QueenHorizontalRightMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("h3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's diagonal move to top left, e3->c5
	public void testPlayer1QueenTopLeftMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("c5");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's diagonal move to top right, e3->g5
	public void testPlayer1QueenTopRightMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("g5");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's diagonal move to bottom left, g5->e3
	public void testPlayer1QueenBottomLeftMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("g5");

		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's diagonal move to top left, c5->e3
	public void testPlayer1QueenBottomRightMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("c5");

		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's capturing enemy, e3->a7
	public void testPlayer1QueenCaptureEnemy() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");

		boolean moveResult = queenAte1.isValidMove("a7");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test Player 1 for Queen's capturing own, e1->d2
	public void testPlayer1QueenCaptureOwn() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("d2");
		assertEquals(moveResult, false);
	}

	@Test
	//Test case: test Player 1 for Queen's top left blocked move, e1->c3 and d2 is blocked (top left)

	public void testPlayer1QueenTopLeftBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("c3");
		assertEquals(moveResult, false);	//	e1->c3 and d2 is blocked (top left)
	}

	@Test
	//Test case: test Player 1 for Queen's forward blocked move, e1->e3 and e2 is blocked (forward)
	public void testPlayer1QueenForwardBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("e3");
		assertEquals(moveResult, false);	//	e1->e3 and e2 is blocked (forward)
	}

	@Test
	//Test case: test Player 1 for Queen's top right blocked move, e1->g3 and f2 is blocked (top right)
	public void testPlayer1QueenTopRightBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("g3");
		assertEquals(moveResult, false);	//	e1->g3 and f2 is blocked (top right)
	}

	@Test
	//Test case: test Player 1 for Queen's left blocked move, e1->e3->c3 and d3 is blocked (left)
	public void testPlayer1QueenLeftBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		ChessPiece queenAte8 = cms.getChessPiece("e8");
		queenAte8.updatePosition("d3");
		boolean moveResult = queenAte1.isValidMove("c3");
		assertEquals(moveResult, false);	//	e1->c1 and d1 is blocked (left)
	}

	@Test
	//Test case: test Player 1 for Queen's right blocked move, e1->g1 and f1 is blocked (right)
	public void testPlayer1QueenRightBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		ChessPiece bisdopAtg1 = cms.getChessPiece("g1");
		bisdopAtg1.updatePosition("a4");
		boolean moveResult = queenAte1.isValidMove("g1");
		assertEquals(moveResult, false);	//	e1->g1 and f1 is blocked (right)
	}

	@Test
	//Test case: test Player 1 for Queen's lower left blocked move, g3->e1 and f2 is blocked (lower left)
	public void testPlayer1QueenLowerLeftBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("g3");
		boolean moveResult = queenAte1.isValidMove("e1");
		assertEquals(moveResult, false);	//	g3->e1 and f2 is blocked (lower left)
	}

	@Test
	//Test case: test Player 1 for Queen's backward blocked move, e3->e1 and e2 is blocked (backward)
	public void testPlayer1QueenBackwardBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("e3");
		boolean moveResult = queenAte1.isValidMove("e1");
		assertEquals(moveResult, false);	//	e3->e1 and e2 is blocked (backward)
	}

	@Test
	//Test case: test Player 1 for Queen's lower right blocked move, c3->e1 and d2 is blocked (lower right)
	public void testPlayer1QueenLowerRightBlockedMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		queenAte1.updatePosition("c3");
		boolean moveResult = queenAte1.isValidMove("e1");
		assertEquals(moveResult, false);	//	c3->e1 and d2 is blocked (lower right)
	}

	@Test
	//Test case: test Player 1 for Queen's invalid move, e1->d6
	public void testPlayer1QueenInvalidMove() {
		ChessPiece queenAte1 = cms.getChessPiece("e1");
		boolean moveResult = queenAte1.isValidMove("d6");
		assertEquals(moveResult, false);
	}

	@Test
	public void testQueenGetScore() {
		Queen queen = new Queen(new ChessPlayer("John", 1), null);
		int score = queen.getScore();
		assertEquals(score, 90);
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
	
	@Test
	public void testOtherPrintQueen() {
		Queen queen = new Queen(new ChessPlayer("John", 3), null);
		String stringResult = queen.toString();
		assertEquals(stringResult, null);
	}
}
