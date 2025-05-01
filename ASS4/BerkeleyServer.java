
import java.io.*;
import java.net.*;
public class BerkeleyServer
{
 public static void main(String[] args) throws IOException
 {
 ServerSocket server = new ServerSocket(5000);
 System.out.println("Server waiting for client...");
 Socket client = server.accept();
 System.out.println("Client connected.");
 BufferedReader in = new BufferedReader(new 
InputStreamReader(client.getInputStream()));
 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
 long serverTime = System.currentTimeMillis();
 long clientTime = Long.parseLong(in.readLine());
 long avgTime = (serverTime + clientTime) / 2;
 long adjustment = avgTime - clientTime;
 out.println(adjustment);
 System.out.println("Time adjustment sent: " + adjustment);
 client.close();
 server.close();
 }
}