package leetcode;

public class Sudoku {

	private void backtrack(char[][] board, int i,  int j) {
        if(i==board.length) {
            display(board);
            return;
        }
        int ni=0;
        int nj=0;
        if(j==board[0].length-1) {
            ni=i+1;
            nj=0;
        } else {
            ni=i;
            nj=j+1;
        }
        
        if(board[i][j] !=  '.') {
            backtrack(board, ni, nj);
        } else {
            for(int p=1; p<=9; p++) {
                if(isValid(board, i, j, (char)(p+'0'))) {
                    board[i][j] = (char)(p+'0');
                    backtrack(board, ni, nj);
                    board[i][j] = '.';
                }
            }
        }
    }
    
    private boolean  isValid(char[][] board, int x,  int y, char p) {
        for(int j=0; j<board[0].length;  j++) {
            if(board[x][j] == p) {
                return false;
            }
        }
        
        for(int i=0; i<board.length; i++) {
            if(board[i][y] == p) {
                return false;
            }
        }
        
        int smi = x/3*3;
        int smj = y/3*3;
        for(int i=0; i<3; i++) {
            for(int j=0;  j<3; j++) {
                if(board[smi+i][smj+j]==p) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void display(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
	public static void main(String[] args) {
		char[][] board = {
					{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}
				};
		Sudoku sudoku = new Sudoku();
		sudoku.backtrack(board,  0, 0);
	}

}
