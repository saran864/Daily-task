/* Console Application :Scientific Calculator 
      Name :            Saran R
      Date :            27.sep.2022   */
import java.util.*;
import java.io.*;
import java.math.*;
interface Calculator
{
	
	public void addition();
	public void subraction();
	public void multiply();
	public void division();
	public void squareRoot();
	public void log();
	public void tan();
    public void sin();
	public void cos();
	public void CubeRoot();
	public void factorial();
}
class Operation implements Calculator
{
    
public void addition(){
Scanner sc=new Scanner(System.in);
System.out.println("Enter Limit of Addition");
int limit =sc.nextInt(),input,sum=0;
while(limit!=0)
{
    System.out.println("Enter number");
	input =sc.nextInt();
	sum=sum+input;
	limit--;
}
System.out.println("Answer is : "+sum);
System.out.println();
}
	public void subraction(){
	    
	    Scanner sc=new Scanner(System.in);
System.out.println("Enter Number 1: ");
int input1=sc.nextInt();
System.out.println("Enter Number 2: ");
int input2=sc.nextInt();
System.out.println("Subraction is: "+(input1-input2));
	    
	}
	public void multiply(){
	     Scanner sc=new Scanner(System.in);
System.out.println("Enter Number 1: ");
int input1=sc.nextInt();
System.out.println("Enter Number 2: ");
int input2=sc.nextInt();
System.out.println("Multiplication is: "+(input1*input2));
	}
    public void division(){
        Scanner sc=new Scanner(System.in);
System.out.println("Enter Dividend: ");
double input1=sc.nextDouble();
System.out.println("Enter Divisor: ");
double input2=sc.nextDouble();
System.out.println(" Quotient is: "+(input1/input2));
System.out.println(" Remainder is: "+(input1%input2));
    }
	public void squareRoot(){
	      Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("Square root is: "+(Math.sqrt(input1)));
	}
	public void log(){
	      Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("log 10 is: "+(Math.log10(input1)));
	}
	public void tan(){
	      Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("Tan  is: "+(Math.tan(input1)));
	}
    public void sin(){
         Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("Sin  is: "+(Math.sin(input1)));
    }
	public void cos(){
	      Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("Cos is: "+(Math.cos(input1)));
	}
	public void CubeRoot(){
	        Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
Double input1=sc.nextDouble();
System.out.println("Cube Root is: "+(Math.cbrt(input1)));
	}
	public void factorial(){
	     Scanner sc=new Scanner(System.in);
System.out.println("Enter Number: ");
int input1=sc.nextInt(),fact=1;
 for(int i=1;i<=input1;i++)
 {
     fact=fact*i;
 }
 System.out.println("factorial is: "+fact);
	}
	
}
public class Main {

public static void main(String[] args)
 {
	 Scanner sc=new Scanner(System.in);
	 Operation op=new Operation();
	  boolean b=true;
	  while(b)
	  {       
	      System.out.println("----------------------------------");
		    System.out.println("1.Addition\n2.Subraction\n3.Multiplication\n4.Division\n5.Sin\n6.Cos\n7.Tan\n8.Log\n9.SquareRoot\n10.CubeRoot\n11.Factorial\n12.Exit");
		  System.out.println("----------------------------------");
		  int userint=sc.nextInt();
		  switch(userint)
		  {
			  case 1:
			  {
				  op.addition();
				  break;
			  }
			   case 2:
			  {
				   op.subraction();
				  break;
			  }
			   case 3:
			  {
				   op.multiply();
				  break;
			  }
			   case 4:
			  {
				  op.division();
				  break;
			  }
			   case 5:
			  {
				  op.sin();
				  break;
			  }
			   case 6:
			  {
				  op.cos();
				  break;
			  }
			   case 7:
			  {
				  op.tan();
				  break;
			  }
			   case 8:
			  {
				  op.log();
				  break;
			  }
			   case 9:
			  {
				  op.squareRoot();
				  break;
			  }
			   case 10:
			  {
				  op.CubeRoot();
				  break;
			  }
			  case 11:
			  {
				op.factorial();
				break;
			  }
			  case 12:
			  {
			   b=false;
				  break;
			  }
			  default:
			  {
				 System.out.println("Please Enter Correct Choice...!");
				 break;
			  }
			  
		  }
		  
	  }
   }

}



