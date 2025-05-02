import java.rmi.*;
import java.util.Scanner;

public class Client{
	public static void main(String[] args){
		        Scanner sc = new Scanner(System.in);
		        try{
		                String serverURL = "rmi://localhost/Server";
		                ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
		                
		                System.out.print("Enter first string: ");
		                String str1 = sc.nextLine();
		                
		                System.out.print("Enter second string: ");
		                String str2 = sc.nextLine();
		                
		                System.out.println("Results");
		                System.out.println("Strings after joining: "+ serverIntf.stringJoin(str1, str2));
		
	          
	          }catch(Exception e){
		                System.out.println("Exception at client" + e.getMessage());
	          }
	    }

}