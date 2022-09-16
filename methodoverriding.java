package metodoverriding;

public class Main
{

  public static void main (String[]args)
  {
    childclass b = new childclass ();
      b.add ();
    parentclass a = new parentclass ();
      a.add ();

  }

}
public class parentclass
{
  void add ()
  {
    System.out.println ("I am parent class");

  }


}
public class childclass extends parentclass
{
  void add ()
  {
    System.out.println ("I am child class");
  }

}
