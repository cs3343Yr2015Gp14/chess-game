package chessGame;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=ChessMonitoringSystem.getInstance();

        System.out.println("Please choose a mode (1- Classic 2- Scoring 3- Scoring+)");
        int mode=0;
        while (true){
        	mode=in.nextInt();
	        if (mode <= 3 && mode >0){
	        	chessMonitoringSystem.startGame(mode);
	        	break;
	        }
	        else{
	        	System.out.println("Invalid Mode! Please enter either 1, 2 or 3");
	        }
        }
		
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
