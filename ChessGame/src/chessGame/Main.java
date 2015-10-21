package chessGame;
import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		ChessMonitoringSystem chessMonitoringSystem=ChessMonitoringSystem.getInstance();

        System.out.println("Please choose a mode (1- Classic 2- Scoring): ");
        int mode=in.nextInt();
        in.nextLine();
        String game=Integer.toString(mode);
        
		
		int numOfPlayer=2;
		ChessPlayer[] players=new ChessPlayer[numOfPlayer];
		for (int i=0;i<numOfPlayer;i++){
			System.out.print("Player "+(i+1)+" name: ");
			String pName=in.nextLine();
			ChessPlayer player=new ChessPlayer(pName,i+1);
			players[i]=player;
		}
//		chessMonitoringSystem.initializeChessBoard();
		
		//Command pattern
		Invoker invo = new Invoker();
		StartGame start = new StartGame();
		invo.callCmd(start);
		invo.execute(players[0], players[1], game);
		int j=0;
		Move move=new Move();
		ShowResult finish = new ShowResult();
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
			String position=oldPos + ":" + newPos;
			invo.callCmd(move);
			boolean success=invo.execute(players[j], null, position);
			chessMonitoringSystem.showAllChessPiecesPosition();
			if(success){
				if (j==0)
					j++;
				else
					j--;
			}
			}while(!chessMonitoringSystem.isKingCaptured());   //Check if King is captured
		invo.callCmd(finish);
		invo.execute(players[0], players[1], null);
		in.close();
		
		
	}

}
