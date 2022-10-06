package hackerrank;

import java.util.Scanner;

public class NumberAlbhabets {
public static void main(String[] args) {
   Scanner sc=new Scanner(System.in);
   System.out.println("ENter value");
     int a=sc.nextInt();
     if(a>0&&a<=999)
     {
    	 alphabets(a);
     }
     
   sc.close();  
     
     
    
   
}
private static void alphabets(int a) {
	
	String [] digits= {" ","one","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	String [] digit= {" " ,"Eleven","Twelwe","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};	
	String [] digits1= {" " ,"ten","Twenty","Thrirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"," Hundred "};
	
	int mod,count=0,s=1,teen=0;
	String d="";
	String f="";
	String g="";
	
	int temp=a; //
	while(temp!=0)//123
	{    
		temp/=10;//12 1 1
		count++;
	}
	int printer=count;
	while(count!=0)
	{
		 mod=a%10;///12
		 switch (s)
		 {
		 case 3:
		 {    
			 
			 g=digits[mod]+digits1[10]+f;
		 }	 
		 
		 case 2:
		 {    if(mod==1) {
			 d=digit[teen];
			 f=digit[0]+d;
			 s++;
			 a/=10;
		 }
		 else if(mod==0)
		 {
			 f=digit[0]+d;
			 s++;
			 a/=10;
		 }
		 else
		 {
			 f=digits1[mod]+digit[0]+d;
			 s++;
			 a/=10;
			 
		 }			 
			 break;		 
		 }
		 case 1:	 
		 {
			 d=digits[mod];
			// teen=mod;
			 s++;
			 a/=10;
			 break; 
		 } 			
		 }
		 count--;
	}	
if(printer==3)
	System.out.println(g);
if(printer==2)
	System.out.println(f);
if(printer==1)
	System.out.println(d);
	
}
}
