
import java.util.*;
public class Tring
{ 
public static void main(String args[]) 
{ 
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of nodes: ");
int numNodes = scanner.nextInt();
System.out.print("Enter sender node: ");
int sender = scanner.nextInt();
System.out.print("Enter receiver node: ");
int receiver = scanner.nextInt();
System.out.print("Enter data to send: ");
int data = scanner.nextInt();
int token = sender ;
System.out.print("Token passing sequence: ");
for (int i = token; i != receiver; i = (i + 1) % numNodes) 
{
System.out.print(i + " -> ");
}
System.out.println(receiver);
System.out.println("Sender " + sender + " sending data: " + data);
for (int i = (sender + 1) % numNodes; i != receiver; i = (i + 1) % numNodes) 
{
System.out.println("Data " + data + " forwarded by node " + i);
}
System.out.println("Receiver " + receiver + " received data: " + data);
scanner.close();
}
}