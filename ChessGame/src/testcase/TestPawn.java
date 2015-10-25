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
import junit.framework.TestCase;

public class TestPawn extends TestCase{
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
	//Test case: test for Player 1 pawn's special move, a2->a4
	public void testPlayer1PawnSpecialMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a2");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a4");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's normal move, a2->a3
	public void testPlayer1PawnForwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a2");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a3");
		assertEquals(moveResult, true);
	}

	@Test
	//Test case: test for Player 1 pawn's capturing enemy, a2->b3
	public void testPlayer1PawnCaptureEnemy() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a2");
		Pawn captureStub = new Pawn(new ChessPlayer("John", 2), "b3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 pawn's capturing own, a2->b3
	public void testPlayer1PawnCaptureOwn() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a2");
		Pawn captureStub = new Pawn(new ChessPlayer("John", 1), "b3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's backward move, a4->b3
	public void testPlayer1PawnBackwardMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a4");
		allChessPieces.add(pawnStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("b3");
		assertEquals(moveResult, false);
	}
	
	@Test
	//Test case: test for Player 1 pawn's blocked move, a2->a3 and a3 blocked
	public void testPlayer1PawnBlockedMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Pawn pawnStub = new Pawn(new ChessPlayer("John", 1), "a2");
		Pawn blockStub = new Pawn(new ChessPlayer("John", 1), "a3");
		allChessPieces.add(pawnStub);
		allChessPieces.add(blockStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = pawnStub.isValidMove("a3");
		assertEquals(moveResult, false);
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
}
