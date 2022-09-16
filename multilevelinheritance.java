package multilevelinheritance;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt(),b=sc.nextInt();
		child d=new child();
		d.callmetod(a,b);

	}

}
public class grandparent {
	public void add(int a,int b)
	{
		int C=a+b;
		System.out.println("Addition is:"+C);
	}
}
public class parent extends grandparent{
	public void div(int a,int b)
	{
		int C=a/b;
		System.out.println("Division is:"+C);
	}
	public void mul(int a,int b)
	{
		int C=a*b;
		System.out.println("Multiply is:"+C);
	}
}
public class child extends parent {
	public void sub(int a,int b)
	{
		int C=a-b;
		System.out.println("Subraction is:"+C);
	}
	void callmetod(int a,int b)
	{
		add(a,b);
		sub(a,b);
		mul(a,b);
		div(a,b);
	}

}

