
package HiraricalInhertance;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		child2 c2=new child2();
		c2.sub(a,b);
		c2.mul(a,b);
		child1 c1=new child1();
		c1.add(a,b);
		c1.mul(a,b);
	}


public class parent {
	
	void mul(int a, int b)
	{
		System.out.println("Parent class: "+(a*b));
	}
	
	
	
}
public class child1 extends parent{
	void add(int a , int b)
	{
		System.out.println("child1 add: "+(a+b));
	}

}
public class child2 extends parent {
	void sub(int a , int b)
	{
		System.out.println("child2 subract: "+(a-b));
	}



	}
