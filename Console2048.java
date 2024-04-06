package game2048;

import java.util.Scanner;

public class Console2048 {
	
	public static void main(String[] args) {
		// objects
		Board board = new Board();
		Moves moves = new Moves();
		Scanner scanner = new Scanner(System.in);
		
		// declare variables
		char move;
		
		moves.createBoard();
		System.out.println(board.printBoard());
		
		
		while (moves.getPlay()) {
			move = scanner.nextLine().charAt(0);
			
			switch (move) {
			case 'w':
				moves.turnUp();
				break;
				
			case 's':
				moves.turnDown();
				break;
				
			case 'a':
				moves.turnLeft();
				break;
				
			case 'd':
				moves.turnRight();
				break;
				
			default:
				System.err.println("invalid");
			}
		}

		System.out.println("game over");
	}
}
