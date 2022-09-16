/*1 1 1 1 1 1 1 1 1 2
  3 2 2 2 2 2 2 2 2 2
  3 3 3 3 3 3 3 3 3 4
  5 4 4 4 4 4 4 4 4 4
  5 5 5 5 5 5 5 5 5 6
  7 6 6 6 6 6 6 6 6 6
  7 7 7 7 7 7 7 7 7 8
  9 8 8 8 8 8 8 8 8 8
  9 9 9 9 9 9 9 9 9 10
  */
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int n=10,i,j,val=2;
	    for(i=1;i<n;i++)
	    { if(i%2!=0)
	        for(j=1;j<n;j++)
	       {
	            System.out.print(i+" ");
	            if(j==n-1)
	            System.out.print(i+1+" ");
	            
	        }
	        else
	        for(j=1;j<=n;j++)
	        { if(i%2==0&&j==1)
	            System.out.print(i+1+" ");
	            else
	            System.out.print(i+" ");
	        }
	         System.out.println();
	    }
		
	}
}

