/**
 * @author 
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
import chessGame.King;
import chessGame.Knight;
import chessGame.Pawn;
import chessGame.Queen;
import chessGame.Rook;
import junit.framework.TestCase;

public class TestChessPiece extends TestCase{
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	
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
	
/*	@Test
	public void testToString() {
		//set 2 players
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			String pName="Player"+(i+1);
			ChessPlayer player=new ChessPlayer(pName,i+1);
			players[i]=player;
		}
		for(int i=0;i<1;i++){
			int j=0; //for changing to Capital Letter
			//set all kinds of chess piece
			ChessPiece pawn=new Pawn(players[i],"n");
			ChessPiece rook=new Rook(players[i],"n");
			ChessPiece knight=new Knight(players[i],"n");
			ChessPiece king=new King(players[i],"n");
			ChessPiece queen=new Queen(players[i],"n");
			ChessPiece bishop=new Bishop(players[i],"n");
			if (i==1)
				j=32;
			assertEquals(""+(char)(80+j),pawn.toString());
			assertEquals(""+(char)(82+j),rook.toString());
			assertEquals(""+(char)(78+j),knight.toString());
			assertEquals(""+(char)(75+j),king.toString());
			assertEquals(""+(char)(81+j),queen.toString());
			assertEquals(""+(char)(66+j),bishop.toString());
		}
	}
*/
	
	@Test
	public void testgetPlayer() {
		ChessPlayer p1=new ChessPlayer("a", 1);
		ChessPiece c = new  Pawn(p1, "a1");
		ChessPlayer result = c.getPlayer();
		assertEquals(p1, result);
	}
	
	@Test
	public void testgetPosition() {
		ChessPlayer p1=new ChessPlayer("a", 1);
		ChessPiece c = new  Pawn(p1, "a1");
		assertEquals("a1", c.getPosition());
	}
	
	@Test
	public void testUpdatePosition(){
		ChessPlayer p1=new ChessPlayer("a", 1);
		ChessPiece c = new  Pawn(p1, "a1");
		c.updatePosition("a2");
		assertEquals("a2", c.getPosition());
	}
}
