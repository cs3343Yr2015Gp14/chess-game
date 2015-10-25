package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

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
	//Test case: test for Player 1 knight's move, b1->c3
	public void testPlayer1KnightMove() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Knight knightStub = new Knight(new ChessPlayer("John", 1), "b1");
		allChessPieces.add(knightStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's move, b1->c3
	public void testPlayer1KnightCaptureEnemy() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Knight knightStub = new Knight(new ChessPlayer("John", 1), "b1");
		Knight captureStub = new Knight(new ChessPlayer("John", 2), "c3");
		allChessPieces.add(knightStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's capturing own, b1->c3
	public void testPlayer1KnightCaptureOwn() {
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		Knight knightStub = new Knight(new ChessPlayer("John", 1), "b1");
		Knight captureStub = new Knight(new ChessPlayer("John", 1), "c3");
		allChessPieces.add(knightStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, false);
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
