import java.util.*;
public class Sudoku
{
   static   int row,col,checkrow,checkcol,check;
	public static void main(String[] args){
	    int sudoku[][]={ {5,0,6,0,2,0,4},
	                     {0,4,0,0,0,7,0},
	                     {2,0,0,4,0,0,3},
	                     {0,0,4,0,7,0,0},
	                     {7,0,0,1,0,0,6},
	                     {0,2,0,0,0,5,0},
	                     {4,0,5,0,3,0,7} };
	         showSudoku(sudoku);
	         solvePuzzle(sudoku);
	}
	static void showSudoku( int sudoku [] [])
	{
	    System.out.println("Solve the Puzzle");
	     System.out.println("-----------------");
	   for(row=0;row<sudoku.length;row++)
	   {  
	       for(col=0;col<sudoku.length;col++)
	       {
	           if(sudoku[row][col]==0)
	            System.out.print("* ");
	            else 
	          System.out.print(sudoku[row][col]+" ");
	          
	          
	       }
	        System.out.println();
	   }
	 System.out.println("----------------");
	 System.out.println("Start Solve ");
	}
	
public static void   solvePuzzle(int sudoku [] [])
{
       Scanner input=new Scanner(System.in);
    for(row=0;row<sudoku.length;row++)
	   {  
	       for(col=0;col<sudoku.length;col++)
	       {
	           if(sudoku[row][col]==0)
	           {
	                System.out.print("Solve row and column["+row+","+col+"] : ");
	              sudoku[row][col]=input.nextInt();
	           }
	          
	           
	          
	       }
	   }
	   boolean  solve=true;
    for(row=0;row<sudoku.length;row++)
	   {  
	       for(col=0;col<sudoku.length;col++)
	       {
	         check=sudoku[row][col];
	         checkrow=row;
	         checkcol=col;
	         while(checkrow+1<sudoku.length)
	         {
	             if(check==sudoku[checkrow+1][checkcol])
	             {
	                 solve =false;
	                System.out.println("Wrong Entry in: "+(checkrow+1)+" "+checkcol);
	             }
	             checkrow++;
	             
	         }
	        checkrow=row;
	         while(checkcol+1<sudoku.length)
	         {
	             if(check==sudoku[checkrow][checkcol+1])
	             {
	                  solve =false;
	                System.out.println("Wrong Entry in :"+checkrow+","+(checkcol+1));
	             }
	             checkcol++;
	             
	         }
   
	       }
	   }
 System.out.println(solve==true ? "Congrats... Puzzle Solved":" Sorry puzzle not solved Try Again !");
	}
    
}

	  
	  
