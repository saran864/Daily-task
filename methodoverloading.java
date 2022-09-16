package methodoverloading;

public class Meth
{
public static void main(String[] args)
{
	add("a","b");
	add("z");
}

void add(String a) {
	System.out.println(a);
	
}
void add(String a,String b) 
{
	
 System.out.println(a+b);
	
}

}
