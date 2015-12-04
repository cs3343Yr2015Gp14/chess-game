/**
 * @author PP
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.Bishop;
import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Pawn;
import chessGame.Rook;
import junit.framework.TestCase;

public class TestPawn extends TestCase{
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
	//Test case: test for Player 1 pawn move to current position, a2->a4
	public void testPlayer1PawnMoveToCurrentPos() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a2");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's special move, a2->a4
	public void testPlayer1PawnSpecialMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 2 pawn's special move, a7->a5
	public void testPlayer2PawnSpecialMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a7");
		boolean moveResult = pawnAta2.isValidMove("a5");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 2 pawn's invalid special move, a2->a5
	public void testPlayer1PawnInvalidSpecialMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a5");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's normal move, a3->a4
	public void testPlayer1PawnForwardMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("a3");
		boolean moveResult = pawnAta2.isValidMove("a4");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a6->b7
	public void testPlayer1PawnCaptureEnemy() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("a6");
		
		boolean moveResult = pawnAta2.isValidMove("b7");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a2->a6, b7->b5, a6->b5
	public void testPlayer1PawnBackwardCaptureEnemy() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("a6");
		
		ChessPiece pawnAtb7 = cms.getChessPiece("b7");
		pawnAtb7.updatePosition("b5");
		
		boolean moveResult = pawnAta2.isValidMove("b5");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a2->b4->c7
	public void testPlayer1PawnInvalidCaptureEnemy() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("b4");
		
		boolean moveResult = pawnAta2.isValidMove("c7");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing own, pawn b2->b3, pawn a2->b3
	public void testPlayer1PawnCaptureOwn() {
		ChessPiece ownPiece = cms.getChessPiece("b2");
		ownPiece.updatePosition("b3");
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, rook a1->a3, a2->a1
	public void testPlayer1PawnBackwardMove() {
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("a1");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a2->h6
	public void testPlayer1PawnInvalidMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		boolean moveResult = pawnAta2.isValidMove("h6");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a2->a6->c7
	public void testPlayer1PawnInvalidMove2() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		pawnAta2.updatePosition("a6");
		boolean moveResult = pawnAta2.isValidMove("c7");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a2->a4
	public void testPlayer1PawnInvalidForwardBlockedMove() {
		ChessPiece pawnAta2 = cms.getChessPiece("a2");
		ChessPiece rookAta1 = cms.getChessPiece("a1");
		rookAta1.updatePosition("a3");
		boolean moveResult = pawnAta2.isValidMove("a4");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 2 pawn's backward move, a7->a5, b2->b6, a5->b6
	public void testPlayer2PawnBackwardMove() {
		ChessPiece pawnAta7 = cms.getChessPiece("a7");
		pawnAta7.updatePosition("a5");
		ChessPiece pawnAtb2 = cms.getChessPiece("b2");
		pawnAtb2.updatePosition("b6");
		boolean moveResult = pawnAta7.isValidMove("b6");
		assertEquals(moveResult, false);
	}
	
	@Test
	public void testPawnGetScore() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 1), null);
		int score = pawn.getScore();
		assertEquals(score, 10);
	}
	
	@Test
	public void testPlayer1PrintPawn() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 1), null);
		String stringResult = pawn.toString();
		assertEquals(stringResult, "P");
	}
	
	@Test
	public void testPlayer2PrintPawn() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 2), null);
		String stringResult = pawn.toString();
		assertEquals(stringResult, "p");
	}
	
	@Test
	public void testOtherPrintPawn() {
		Pawn pawn = new Pawn(new ChessPlayer("John", 3), null);
		String stringResult = pawn.toString();
		assertEquals(stringResult, null);
	}
}
