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

public class TestCMS extends TestCase{
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
	
	@Test
	public void testInitializeAndGetChessPiece() {
		//set players
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			String pName="Player"+(i+1);
			ChessPlayer player=new ChessPlayer(pName,i+1);
			players[i]=player;
		}
		//initialize chess pieces
		chessMonitoringSystem.initializeChessPieces(players[0],players[1]);
		//check player1's pawn
		for(int i=97;i<97+8;i++){
			String position=(char)i+"2";
			ChessPiece chess=chessMonitoringSystem.getChessPiece(position);
			assertEquals("P",chess.toString());  //used third party: Pawn.toString();
		}
		//check player2's pawn
		for(int i=97;i<97+8;i++){
			String position=(char)i+"7";
			ChessPiece chess=chessMonitoringSystem.getChessPiece(position);
			assertEquals("p",chess.toString());  //used third party: Pawn.toString();
		}
		
		//check other chess piece
		for(int i=0;i<1;i++){
			int j=0; //for changing to Capital Letter
			int k=1; //for changing to player2's position: (a-h)8
			if(i==1){
				j=32;
				k=8;
			}
			ChessPiece chess1=chessMonitoringSystem.getChessPiece("a"+k);
			ChessPiece chess2=chessMonitoringSystem.getChessPiece("b"+k);
			ChessPiece chess3=chessMonitoringSystem.getChessPiece("c"+k);
			ChessPiece chess4=chessMonitoringSystem.getChessPiece("d"+k);
			ChessPiece chess5=chessMonitoringSystem.getChessPiece("e"+k);
			ChessPiece chess6=chessMonitoringSystem.getChessPiece("f"+k);
			ChessPiece chess7=chessMonitoringSystem.getChessPiece("g"+k);
			ChessPiece chess8=chessMonitoringSystem.getChessPiece("h"+k);
			
			assertEquals(""+(char)(82+j),chess1.toString()); //rook
			assertEquals(""+(char)(78+j),chess2.toString()); //knight
			assertEquals(""+(char)(66+j),chess3.toString()); //bishop
			assertEquals(""+(char)(75+j),chess4.toString()); //king
			assertEquals(""+(char)(81+j),chess5.toString()); //queen
			assertEquals(""+(char)(66+j),chess6.toString()); //bishop
			assertEquals(""+(char)(78+j),chess7.toString()); //knight
			assertEquals(""+(char)(82+j),chess8.toString()); //rook
		}
	}
}
