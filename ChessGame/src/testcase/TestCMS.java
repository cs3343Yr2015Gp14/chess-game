/**
 * @author PP, Eva
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
	
	@Test
	public void testremoveChessPiece() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("a1");
		ChessPiece result = chessMonitoringSystem.getChessPiece("a1");
		assertEquals(result,null);
	}
	
	//test IsKingCaptured()
	@Test
	public void testIsKingCapturedZeroLoop() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		for (int i=1;i<9;i++){
			for(int j=1;j<3;j++){
				String position = Character.toString((char)(96+i)) + j;
				//removeChessPiece have been tested in the beginning.
				chessMonitoringSystem.removeChessPiece(position);
			}
			for(int j=7;j<9;j++){
				String position = Character.toString((char)(96+i)) + j;
				chessMonitoringSystem.removeChessPiece(position);
			}
		}
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,null);
	}
	
	public void testIsKingCapturedOneLoopNotKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		for (int i=1;i<9;i++){
			for(int j=1;j<3;j++){
				String position = Character.toString((char)(96+i)) + j;
				//removeChessPiece have been tested in the beginning.
				chessMonitoringSystem.removeChessPiece(position);
			}
			for(int j=7;j<9;j++){
				if (j!=7&&i!=1){
					String position = Character.toString((char)(96+i)) + j;
					chessMonitoringSystem.removeChessPiece(position);
				}
			}
		}
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,null);
	}
	
	public void testIsKingCapturedOneLoopIsKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		for (int i=1;i<9;i++){
			for(int j=1;j<3;j++){
				String position = Character.toString((char)(96+i)) + j;
				//removeChessPiece have been tested in the beginning.
				chessMonitoringSystem.removeChessPiece(position);
			}
			for(int j=7;j<9;j++){
				if (j!=8&&i!=4){
					String position = Character.toString((char)(96+i)) + j;
					chessMonitoringSystem.removeChessPiece(position);
				}
			}
		}
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,p2);
	}
	
	public void testIsKingCapturedMoreThanOneLoop() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,null);
	}
	
	public void testIsKingCapturedMoreThanOneLoopNoKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		chessMonitoringSystem.removeChessPiece("d1");
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,null);
	}
	
	public void testIsKingCapturedMoreThanOneLoopOneKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(result,p1);
	}
	
	
}
