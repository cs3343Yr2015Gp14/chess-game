package chessGame;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=ChessMonitoringSystem.getInstance();

        System.out.println("Please choose a mode (1- Classic 2- Scoring 3- Scoring+)[default: Classic]: ");
        int mode=in.nextInt();
        in.nextLine();
        GameMode game= null;
        switch (mode){
        	case 1:
        		game = new ClassicMode();
        	case 2:
        		game = new ScoringMode();
        	case 3:
        		game = new RankScoringMode();
        	default:
        		game = new ClassicMode();
        }
        chessMonitoringSystem.startGame(game);
		
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			System.out.print("Player "+(i+1)+" name: ");
			String pName=in.nextLine();
			ChessPlayer player=new ChessPlayer(pName,i+1);
			players[i]=player;
		}
//		chessMonitoringSystem.initializeChessBoard();
		chessMonitoringSystem.initializeChessPieces(players[0],players[1]);
		chessMonitoringSystem.showAllChessPiecesPosition();
		
		int j=0;
		do{
			System.out.print("Player "+(j+1)+", ");
			if (j==0)
				System.out.println("Your chess pieces are in UPPER-CASE.");
			else
				System.out.println("Your chess pieces are in lower-case.");
			System.out.println("Please enter the position of the chess piece you want to move: (example: \"a1\")");
			String oldPos=in.next();
			System.out.println("Please enter the new position: ");
			String newPos=in.next();
			boolean move=chessMonitoringSystem.moveChessPiece(players[j], oldPos, newPos);
			chessMonitoringSystem.showAllChessPiecesPosition();
			if(move){
				if (j==0)
					j++;
				else
					j--;
			}
		}while(!chessMonitoringSystem.endGame());   //Check if King is captured
		chessMonitoringSystem.getResult(players[0], players[1]);
		in.close();
		System.out.println("This is the end of the game!");
	}

}
