package inheritance;

public class Main {

	public static void main(String[] args) {
		classB b=new classB();
		b.add();
		b.sub();
	}

}

public class ClassA {
	 void add()
		{   int a=103,b=910,c=a+b;
		 System.out.println(c);
			
		}
	
}

class classB  extends ClassA{
	  void sub()
	  {
		  int a=200,b=56,c=a-b;
		 System.out.println(c);
		
		  
	  }

}