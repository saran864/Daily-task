import java.util.*;
public class Main{
    static {
               System.out.println("Enter Result Number");
               
    }
     
           Scanner sc=new Scanner (System.in);
            int e=sc.nextInt();
          
     
       
    public  void permute(List<Integer> arr, int k){
        
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size()-1){
            
            if(arr.get(0)+arr.get(1)+arr.get(2)+arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"+"+arr.get(1)+"+"+arr.get(2)+"+"+arr.get(3)+"="+e);
            }
            if(arr.get(0)-arr.get(1)-arr.get(2)-arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"-"+arr.get(1)+"-"+arr.get(2)+"-"+arr.get(3)+"="+e);
            }
             if(arr.get(0)*arr.get(1)*arr.get(2)*arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"*"+arr.get(1)+"*"+arr.get(2)+"*"+arr.get(3)+"="+e);
            }
            if(arr.get(0)/arr.get(1)/arr.get(2)/arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"/"+arr.get(1)+"/"+arr.get(2)+"/"+arr.get(3)+"/"+e);
            }
            
             if(arr.get(0)+arr.get(1)-arr.get(2)*arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"+"+arr.get(1)+"-"+arr.get(2)+"*"+arr.get(3)+"="+e);
            }
            if(arr.get(0)+arr.get(1)*arr.get(2)-arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"+"+arr.get(1)+"*"+arr.get(2)+"-"+arr.get(3)+"="+e);
            }
             if(arr.get(0)-arr.get(1)*arr.get(2)+arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"-"+arr.get(1)+"*"+arr.get(2)+"+"+arr.get(3)+"="+e);
            }
            if(arr.get(0)-arr.get(1)+arr.get(2)*arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"-"+arr.get(1)+"+"+arr.get(2)+"*"+arr.get(3)+"="+e);
            }
            
             if(arr.get(0)*arr.get(1)+arr.get(2)-arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"*"+arr.get(1)+"+"+arr.get(2)+"-"+arr.get(3)+"="+e);
            }
            if(arr.get(0)*arr.get(1)-arr.get(2)+arr.get(3)==e)
            {
                 System.out.println(arr.get(0)+"*"+arr.get(1)+"-"+arr.get(2)+"+"+arr.get(3)+"="+e);
            }
             
            
        }
    }
    public static void main(String[] args){
       Main m=new Main();
       Scanner sc=new Scanner (System.in);

    System.out.println("Enter four Number");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        
        m.permute(Arrays.asList(a,b,c,d), 0 );
    }
}

