import java.rmi.*;
import java.util.Scanner;

public class AddClient{
	public static void main(String[] args){
		        Scanner sc = new Scanner(System.in);
		        try{
		                String serverURL = "rmi://localhost/Server";
		                ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
		                
		                System.out.print("Enter first number: ");
		                double num1 = sc.nextDouble();
		                
		                System.out.print("Enter second number: ");
		                double num2 = sc.nextDouble();
		                
		                System.out.println("1st number: "+num1);
		                System.out.println("2nd number: "+num2);
		                
		                System.out.println("Addition "+serverIntf.Addition(num1, num2));
		                System.out.println("Subtraction "+serverIntf.Subtraction(num1, num2));
		                System.out.println("Multiplication "+serverIntf.Multiplication(num1, num2));
		                System.out.println("Division "+serverIntf.Division(num1, num2));
		
	          
	          }catch(Exception e){
		                System.out.println("Ex:" + e.getMessage());
	          }
	    }

}