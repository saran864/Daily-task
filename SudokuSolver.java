public class SudokuSolver {
     public static void main(String[] args) {
    int[][] board = new int[][] 
           {{8, 4, 9, 0, 0, 3, 5, 7, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 9, 0, 0, 8, 3},
            {0, 0, 0, 9, 4, 6, 7, 0, 0},
            {0, 8, 0, 0, 5, 0, 0, 4, 0},
            {0, 0, 6, 8, 7, 2, 0, 0, 0},
            {5, 7, 0, 0, 1, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 2, 1, 7, 0, 0, 8, 6, 5}};
            displayBoard(board);
    int boardLength = board.length;
    if (sudokuProblem(board, boardLength)) {
      printSudokuBoard(board, boardLength);
      System.out.println("Puzzle solved successfully!");
    } else {
      System.out.println("Not solved");
    }
     }
    public static void displayBoard(int [][] board){
         System.out.println("Solve Puzzle ");
         System.out.println("-----------------------");
         for (int row=0;row<board.length;row++) {
         for (int col=0;col<board.length;col++) 
         {
             System.out.print(board[row][col]+" ");
         }
         System.out.println();
    }
     System.out.println("-----------------------");
    }
   public static boolean sudokuProblem(int[][] board, int n) {
    int row=-1;
    int col=-1;
    boolean isEmpty=true;
    for (int i=0;i<n;i++) {
      for (int j=0;j<n;j++) {
        if (board[i][j]==0) {
          row=i;
          col=j;
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }
    if (isEmpty) {
      return true;
    }

    for (int num=1; num<=n;num++) {
      if (SafePlace(board, row, col, num)) {
        
        board[row][col] = num;//0=1  
        
        if (sudokuProblem(board,n)) {
          return true;
        } else {
          board[row][col] = 0; 
        }
      }
    }

    return false;
  }

  public static boolean SafePlace(int[][] board, int row, int col, int num) {
    for (int checkCol = 0; checkCol < board.length; checkCol++) {
      if (board[row][checkCol] == num) {
        return false;
      }
    }
    for (int checkRow = 0; checkRow < board.length; checkRow++) {
      if (board[checkRow][col] == num) {
        return false;
      }
    }
    int sqrt = (int) Math.sqrt(board.length);
    int rowStart = row-row%sqrt;
    int colStart = col-col%sqrt;

    for (int r = rowStart; r < rowStart + sqrt; r++) {
      for (int d = colStart; d < colStart + sqrt; d++) {
        if (board[r][d] == num) {
          return false;
        }
      }
    }
    return true;
  } 
  public static void printSudokuBoard(int[][] board, int sudokuLength) { 
      for (int row = 0; row <sudokuLength; row++) { 
          for (int col = 0; col < sudokuLength; col++) { 
              System.out.print(board[row][col]); 
              System.out.print(" "); 
          } 
          System.out.println(); 
      } 
  } 
 
  
}
