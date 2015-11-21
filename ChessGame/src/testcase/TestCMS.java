/**
 * @author PP, Eva
 *
 */
package testcase;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import chessGame.ChessMonitoringSystem;
import chessGame.ChessPiece;
import chessGame.ChessPlayer;
import chessGame.ClassicMode;
import chessGame.GameMode;
import chessGame.Pawn;
import chessGame.Queen;
import chessGame.RankScoringMode;
import chessGame.Rook;
import chessGame.ScoringMode;
import chessGame.Bishop;
import junit.framework.TestCase;

public class TestCMS extends TestCase{
	private ChessMonitoringSystem chessMonitoringSystem = ChessMonitoringSystem.getInstance();
	private GameMode mode;
	
	private ByteArrayOutputStream baos;
	private PrintStream ps;
	private void initialise(){
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        System.setOut(ps);
        //assertTrue(baos.toString().equals("Main"));
    }
	
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
	
	
	//test removeChessPiece
	@Test
	public void testremoveChessPiece() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("a1");
		ChessPiece result = chessMonitoringSystem.getChessPiece("a1");
		assertEquals(null, result);
	}
	
	//test IsKingCaptured()
	@Test
	public void testIsKingCapturedZeroLoop() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		for (int i=1;i<9;i++){
			for(int j=1;j<9;j++){
				if (j==3)
					j=7;
				String position = Character.toString((char)(96+i)) + j;
				//removeChessPiece have been tested in the beginning.
				chessMonitoringSystem.removeChessPiece(position);
			}
		}
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(null, result);
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
		assertEquals(null, result);
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
		assertEquals(p2, result);
	}
	
	public void testIsKingCapturedMoreThanOneLoop() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(null, result);
	}
	
	public void testIsKingCapturedMoreThanOneLoopNoKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		chessMonitoringSystem.removeChessPiece("d1");
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(null, result);
	}
	
	public void testIsKingCapturedMoreThanOneLoopOneKing() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		ChessPlayer result = chessMonitoringSystem.isKingCaptured();
		assertEquals(p1, result);
	}
	
	//test showAllChessPiecesPosition
	@Test
	public void testshowAllChessPiecesPositionNoChesses() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		for (int i=1;i<9;i++){
			for(int j=1;j<9;j++){
				if (j==3)
					j=7;
				String position = Character.toString((char)(96+i)) + j;
				chessMonitoringSystem.removeChessPiece(position);
			}
		}
		chessMonitoringSystem.showAllChessPiecesPosition();
		String chessboard="  a b c d e f g h" + "\n" + "8 O O O O O O O O 8" + "\n" + "7 O O O O O O O O 7" + "\n" + "6 O O O O O O O O 6" + "\n" + "5 O O O O O O O O 5" + "\n" + "4 O O O O O O O O 4" + "\n" + "3 O O O O O O O O 3" + "\n" + "2 O O O O O O O O 2"+ "\n" + "1 O O O O O O O O 1" + "\n" + "  a b c d e f g h\n";
		assertEquals(chessboard, baos.toString());
	}
	
	public void testshowAllChessPiecesPositionHaveChesses() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.showAllChessPiecesPosition();
		String chessboard="  a b c d e f g h" + "\n" + "8 r n b k q b n r 8" + "\n" + "7 p p p p p p p p 7" + "\n" + "6 O O O O O O O O 6" + "\n" + "5 O O O O O O O O 5" + "\n" + "4 O O O O O O O O 4" + "\n" + "3 O O O O O O O O 3" + "\n" + "2 P P P P P P P P 2"+ "\n" + "1 R N B K Q B N R 1" + "\n" + "  a b c d e f g h\n";
		assertEquals(chessboard, baos.toString());
	}
	
	//test compareScore
	public void testcompareScore0(){
		ChessPiece queen = new Queen(null, "a1");
		ChessPiece rook = new Rook (null, "a2");
		int result = chessMonitoringSystem.compareScore(queen, rook);
		assertEquals(0, result);
	}
	
	public void testcompareScore1(){
		ChessPiece queen = new Queen(null, "a1");
		ChessPiece rook = new Rook (null, "a2");
		int result = chessMonitoringSystem.compareScore(rook, queen);
		assertEquals(1, result);
	}
	
	public void testcompareScore2(){
		ChessPiece q1 = new Queen(null, "a1");
		ChessPiece q2 = new Queen (null, "a2");
		int result = chessMonitoringSystem.compareScore(q1, q2);
		assertEquals(2, result);
	}
	
	//test start game
	public void teststartGameClassic(){
		initialise();
		chessMonitoringSystem.startGame(1);
		assertTrue(baos.toString().equals("This is Classic Mode.\n"));
	}
	
	public void teststartGameScoring(){
		initialise();
		chessMonitoringSystem.startGame(2);
		assertTrue(baos.toString().equals("This is Scoring Mode.\n"));
	}
	
	public void teststartGameScoringPlus(){
		initialise();
		chessMonitoringSystem.startGame(3);
		assertTrue(baos.toString().equals("This is Scoring+ Mode.\n"));
	}
	
	//test endGame integration test (GameMode.isEndGame + CMS)
	public void testEndGameNotEndGame() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = chessMonitoringSystem.endGame();
		assertEquals(false, result);
	}
	
	public void testEndGameEndGame() {
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.startGame(1);
		chessMonitoringSystem.removeChessPiece("d8");
		boolean result = chessMonitoringSystem.endGame();
		assertEquals(true, result);
	}
	
	//test getResult integration test (GameMode.printResult + CMS)
	@Test
	public void testgetResultP1WinClassic() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d8");
		chessMonitoringSystem.endGame();
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Classic Mode.\n" + "a is the winner!\n", baos.toString());
	}
	
	@Test
	public void testgetResultP2WinClassic() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.removeChessPiece("d1");
		chessMonitoringSystem.endGame();
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Classic Mode.\n" + "b is the winner!\n", baos.toString());
	}
	
	@Test
	public void testgetResultP1WinScoring() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		int[] scoreRelated={100, 0};
		mode = new ScoringMode();
		mode.addScore(p1, scoreRelated);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring Mode.\n" + "a" + " is the winner!" + "\n" + "winner's score: 100\n", baos.toString());
	}
	
	@Test
	public void testgetResultP2WinScoring() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		int[] scoreRelated={100, 0};
		mode = new ScoringMode();
		mode.addScore(p2, scoreRelated);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring Mode.\n" + "b" + " is the winner!" + "\n" + "winner's score: 100\n", baos.toString());
	}
	
	@Test
	public void testgetResultDrawScoring() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring Mode.\n" + "Draw!\n", baos.toString());
	}
	
	@Test
	public void testgetResultP1WinScoringPlus() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		mode = new RankScoringMode();
		int[] scoreRelated={100, 0};
		mode.addScore(p1, scoreRelated);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring+ Mode.\n" + "a"+ " is the winner!" + "\n" + "winner's score: 80\n", baos.toString());
	}
	
	@Test
	public void testgetResultP2WinScoringPlus() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 0);
		ChessPlayer p2 = new ChessPlayer("b", 0);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		mode = new RankScoringMode();
		int[] scoreRelated={100, 0};
		mode.addScore(p2, scoreRelated);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring+ Mode.\n" + "b"+ " is the winner!" + "\n" + "winner's score: 80\n", baos.toString());
	}
	
	@Test
	public void testgetResultDrawScoringPlus() {
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.getResult(p1, p2);
		assertEquals("This is Scoring+ Mode.\n" + "Draw!\n", baos.toString());
	}
	
	//test moveChessPiece
	//test Update Success
	@Test
	public void testVaildMoveChessPieceNotRemove(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a2", "a3");
		assertEquals(true, result);
	}
	
	//test UpdateSuccessAndRemove
	@Test
	public void testVaildMoveChessPieceRemove(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Pawn = chessMonitoringSystem.getChessPiece("a7");
		p2Pawn.updatePosition("b3");
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		assertEquals(true, result);
	}
	
	@Test
	public void testVaildMoveChessPieceAddScoreClassic(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(1);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Pawn = chessMonitoringSystem.getChessPiece("a7");
		p2Pawn.updatePosition("b3");
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		int result = p1.getPlayerScore();
		assertEquals(0, result);
	}
	
	@Test
	public void testVaildMoveChessPieceAddScoreScoring(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Pawn = chessMonitoringSystem.getChessPiece("a7");
		p2Pawn.updatePosition("b3");
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		int result = p1.getPlayerScore();
		assertEquals(10, result);
	}
	
	@Test
	public void testVaildMoveChessPieceAddScoreScoringPlusHigher(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Queen = chessMonitoringSystem.getChessPiece("e8");
		p2Queen.updatePosition("b3");
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		int result = p1.getPlayerScore();
		assertEquals(108, result);
	}
	
	@Test
	public void testVaildMoveChessPieceAddScoreScoringPlusSame(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Pawn = chessMonitoringSystem.getChessPiece("a7");
		p2Pawn.updatePosition("b3");
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		int result = p1.getPlayerScore();
		assertEquals(10, result);
	}
	
	@Test
	public void testVaildMoveChessPieceAddScoreScoringPlusLower(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.startGame(3);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Queen = chessMonitoringSystem.getChessPiece("e8");
		p2Queen.updatePosition("e4");
		chessMonitoringSystem.moveChessPiece(p2, "e4", "c2");
		int result = p2.getPlayerScore();
		assertEquals(8, result);
	}
	
	@Test
	public void testVaildMoveChessPieceRemoveSuccess(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p2Queen = chessMonitoringSystem.getChessPiece("e8");
		p2Queen.updatePosition("e4");
		chessMonitoringSystem.moveChessPiece(p2, "e4", "c2");
		int counter = 0;
		for (int i=1;i<9;i++){
			for(int j=1;j<9;j++){
				String position = Character.toString((char)(96+i)) + j;
				ChessPiece c = chessMonitoringSystem.getChessPiece(position);
				if (c instanceof Pawn)
					counter++;
			}
		}
		assertEquals(15, counter);
	}
	
	@Test
	public void testVaildMoveChessPieceRemoveGetOwnPiece(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p1Pawn = chessMonitoringSystem.getChessPiece("b2");
		p1Pawn.updatePosition("b3");
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		assertEquals(false, result);
	}
	
	/*
	@Test
	public void testVaildMoveChessPieceRemoveGetOwnPieceMessagePawn(){
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p1Pawn = chessMonitoringSystem.getChessPiece("b2");
		p1Pawn.updatePosition("b3");
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		assertEquals("[You cannot capture your own chessPiece!]", baos.toString());
	}
	
	@Test
	public void testVaildMoveChessPieceRemoveGetOwnPieceMessageOther(){
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		ChessPiece p1Rook1 = chessMonitoringSystem.getChessPiece("a1");
		ChessPiece p1Rook2 = chessMonitoringSystem.getChessPiece("h1");
		p1Rook1.updatePosition("a3");
		p1Rook2.updatePosition("c3");
		chessMonitoringSystem.moveChessPiece(p1, "a3", "c3");
		assertEquals("[You cannot capture your own chessPiece!]", baos.toString());
	}*/
	
	@Test
	public void testVaildMoveChessPieceNotValidMove(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		assertEquals(false, result);
	}
	
	@Test
	public void testVaildMoveChessPieceNotValidMoveMessage(){
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.moveChessPiece(p1, "a2", "b3");
		assertEquals("[The move is invalid.]\n", baos.toString());
	}
	
	@Test
	public void testVaildMoveChessPieceNotPlayerChess(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a7", "a6");
		assertEquals(false, result);
	}
	
	@Test
	public void testVaildMoveChessPieceNotPlayerChessMessage(){
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.moveChessPiece(p1, "a7", "a6");
		assertEquals("[Selected piece does not belong to you!]\n", baos.toString());
	}
	
	@Test
	public void testVaildMoveChessPieceNullChess(){
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		boolean result = chessMonitoringSystem.moveChessPiece(p1, "a3", "a4");
		assertEquals(false, result);
	}
	
	@Test
	public void testVaildMoveChessPieceNullChessMessage(){
		initialise();
		ChessPlayer p1 = new ChessPlayer("a", 1);
		ChessPlayer p2 = new ChessPlayer("b", 2);
		chessMonitoringSystem.initializeChessPieces(p1,p2);
		chessMonitoringSystem.moveChessPiece(p1, "a3", "a4");
		assertEquals("[Chesspiece not found!]\n", baos.toString());
	}
}
