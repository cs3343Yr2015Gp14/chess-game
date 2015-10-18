package chessGame;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=ChessMonitoringSystem.getInstance();

        System.out.println("Please choose a mode (1- Classic 2- Scoring): ");
        int mode=in.nextInt();
        in.nextLine();
		
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
			System.out.println("Please enter the position of the chess piece you want to move: ");
			String oldPos=in.nextLine();
			System.out.println("Please enter the new position: ");
			String newPos=in.nextLine();
			boolean move=chessMonitoringSystem.moveChessPiece(players[j],oldPos,newPos);
			chessMonitoringSystem.showAllChessPiecesPosition();
			if(move){
				if (j==0)
					j++;
				else
					j--;
			}
			}while(!chessMonitoringSystem.isKingCaptured());   //Check if King is captured
		chessMonitoringSystem.getGameResult(mode);
		
		in.close();
		
		
	}

}
