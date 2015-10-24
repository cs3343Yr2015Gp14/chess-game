package testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.Knight;
import junit.framework.TestCase;

public class TestKnight extends TestCase{
	private ChessMonitoringSystem cms;
	
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
	public void setUp() {
		cms = ChessMonitoringSystem.getInstance();
	}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
	public void tearDown() {}
	
	@Test
	//Test case: test for Player 1 knight's move, b1->c3
	public void testPlayer1KnightMove() {
		class KnightTestStub extends Knight {
			public KnightTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		KnightTestStub knightStub = new KnightTestStub(new PlayerTestStub("John", 1), "b1");
		allChessPieces.add(knightStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's move, b1->c3
	public void testPlayer1KnightCaptureEnemy() {
		class KnightTestStub extends Knight {
			public KnightTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		KnightTestStub knightStub = new KnightTestStub(new PlayerTestStub("John", 1), "b1");
		KnightTestStub captureStub = new KnightTestStub(new PlayerTestStub("John", 2), "c3");
		allChessPieces.add(knightStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, true);
	}
	
	@Test
	//Test case: test for Player 1 knight's capturing own, b1->c3
	public void testPlayer1KnightCaptureOwn() {
		class KnightTestStub extends Knight {
			public KnightTestStub(ChessPlayer player, String position) {
				super(player, position);
			}
		}
		
		class PlayerTestStub extends ChessPlayer {
			public PlayerTestStub(String playerName, int id) {
				super(playerName, id);
			}
		}
		
		ArrayList<ChessPiece> allChessPieces = new ArrayList<>();
		KnightTestStub knightStub = new KnightTestStub(new PlayerTestStub("John", 1), "b1");
		KnightTestStub captureStub = new KnightTestStub(new PlayerTestStub("John", 1), "c3");
		allChessPieces.add(knightStub);
		allChessPieces.add(captureStub);
		cms.setAllChessPieces(allChessPieces);
		boolean moveResult = knightStub.isValidMove("c3");
		assertEquals(moveResult, false);
	}
}
