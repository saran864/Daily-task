/*Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

Function description

Complete the  function in the editor below.

diagonalDifference takes the following parameter:

int arr[n][m]: an array of integers
Return

int: the absolute diagonal difference
Input Format

The first line contains a single integer, , the number of rows and columns in the square matrix .
Each of the next  lines describes a row, , and consists of  space-separated integers .

Constraints

Output Format

Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12
Sample Output

15
Explanation

The primary diagonal is:

11
   5
     -12
Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10
Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15

Note: |x| is the absolute value of x*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);  
         int n=sc.nextInt();
         if(n>=-100&&n<=100)
         {
          int a[][] = new int[n][n],i,j,sum=0,dif=0;
        for ( i = 0; i < n; i++) {
            for ( j = 0; j < n; j++)
            {  
                a[i][j] = sc.nextInt();
            }
        }
        for ( i = 0; i < n; i++) {
            for ( j = 0; j < n; j++)
            {  if(i==j)
                sum+=a[i][j];
                if((i+j)==n-1)
                dif+=a[i][j];
                
            }    
        }
        int min=sum-dif;
        System.out.println(Math.abs(min));
         }
           
            
        
      
    
}
}
