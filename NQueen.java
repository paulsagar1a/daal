package leetcode;

public class NQueen {

	public static void main(String[] args) {
		printNQueens(4);
	}

	private static void printNQueens(int n) {
		char[][] chess = new char[n][n];
		for(int row=0; row<chess.length;row++) {
			for(int col=0; col<chess.length; col++) {
				chess[row][col] = '.';
			}
		}
		
		backtrack(chess, 0);
		//printChess(chess);
	}

	private static void printChess(char[][] chess) {
		for(int row=0; row<chess.length;row++) {
			for(int col=0; col<chess.length; col++) {
				System.out.print(chess[row][col]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	private static void backtrack(char[][] chess, int row) {
		if(row == chess.length) {
			printChess(chess);
			return;
		}
		
		for(int col=0; col<chess.length; col++) {
			if(isSafe(chess, row, col)) {
				chess[row][col] = 'Q';
				backtrack(chess, row+1);
				chess[row][col] = '.';
			}
		}
	}

	private static boolean isSafe(char[][] chess, int row, int col) {
		//check column safe
		for(int i=row-1, j=col; i>=0; i--) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		//check diagonal left
		for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		//check diagonal right
		for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++) {
			if(chess[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}

}
