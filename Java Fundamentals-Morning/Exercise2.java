import java.util.*;


public class Exercise2 {
    
    public static int fun1(int x,int y){
	    if(y==0){
	        throw new ArithmeticException("division by zero");
	    }
	    return x/y;
	}
    
    public static int fun2(int x,int y) throws ArithmeticException{
        
        return x/y;
    }
	
	public static void main(String args[]) 
    { 
		
	    int res=0,x,y;
	    
		Scanner sc = new Scanner(System.in);
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		try{
		    res = fun1(x,y);
		}catch(ArithmeticException e){
		    System.out.println(e.getMessage());
		    res=-1;
		}
		
	   System.out.println("Result :" + res);
	   
	   
	   try{
		    res = fun2(x,y);
		}catch(ArithmeticException e){
		    System.out.println("\n"+e.getMessage());
		    res=-1;
		}
		
	   System.out.println("Result :" + res);
	    
    }  
}