
import java.io.*;
import java.net.*;
public class BerkeleyClient
{
 public static void main(String[] args) throws IOException
 {
 Socket socket = new Socket("localhost", 5000);
 BufferedReader in = new BufferedReader(new 
InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 long localTime = System.currentTimeMillis();
 out.println(localTime);
 long adjustment = Long.parseLong(in.readLine());
 long newTime = localTime + adjustment;
 System.out.println("Time adjusted: " + newTime);
 
 socket.close();
 }
}