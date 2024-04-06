package game2048;

public class Console2048 {
	public static void main(String[] args) {
		Board board = new Board();
		Moves moves = new Moves();
		
		moves.createBoard();
		moves.createBoard();
		moves.createBoard();
		
		System.out.println(board.printBoard());
		moves.moveDown();
		moves.mergeDown();
		
		System.out.println(board.printBoard());
		moves.moveRight();
		moves.mergeRight();
		System.out.println(board.printBoard());
		moves.mergeLeft();
		System.out.println(board.printBoard());
		moves.mergeLeft();
		System.out.println(board.printBoard());
	}
}
