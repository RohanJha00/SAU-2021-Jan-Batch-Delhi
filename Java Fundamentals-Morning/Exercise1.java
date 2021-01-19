import java.util.*;


public class Exercise1 {
	
	public static void main(String args[]) 
    { 
		
	    int i,n,range=100;
	    ArrayList<Integer> list = new ArrayList<Integer>();  
	    
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
	
	    n = sc.nextInt();
	   
	   
	    for(i=0;i<n;i++){
	        list.add(rd.nextInt(range)); 
	    }
	    
	
	    System.out.println("List before sorting :" + list);          
	   
	    Collections.sort(list);  
	      
	    System.out.println("List after sorting :" + list);
	    
    }  
}