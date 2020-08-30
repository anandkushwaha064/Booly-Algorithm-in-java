import java.io.*;
import java.net.*;
import java.lang.management.*;
import java.net.*; 
import java.util.Arrays; 
 
public class Client
{
 
    private static Socket socket;
 
    public static void main(String args[])
    {
        try
        {
         	 
            int port = 25000;
            InetAddress address = InetAddress.getByName("192.168.43.29");
            socket = new Socket(address, port);
 			System.out.println(socket);
            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
			long diskSize = new File("/").getTotalSpace();
        	String userName = System.getProperty("user.name");

			InetAddress myIP =InetAddress.getLocalHost();			
			long maxMemory = Runtime.getRuntime().maxMemory();
			long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
			System.out.println("Size of C:="+diskSize+" Bytes");
			System.out.println("User Name="+userName);
			System.out.println("RAM Size="+memorySize+" Bytes");
			System.out.println("IP = " + myIP.getHostAddress() );
            String number =userName ;
            String sendMessage = number + "\n";
            bw.write(sendMessage);
	 		sendMessage = maxMemory + "\n";
            bw.write(sendMessage);
 			sendMessage = memorySize + "\n";
            bw.write(sendMessage);
			sendMessage = myIP.getHostAddress() + "\n";			
			bw.write(sendMessage);	    
            bw.flush();

        //    System.out.println("Message sent to the server : "+sendMessage); 
            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            System.out.println("Message received from the server : " +message+"\n");
			String numr = br.readLine();
			String ip = br.readLine();
			System.out.println("******************************************************************");
			System.out.println("Coordinator is "+ numr +"\nIp4 address of Coordinator "+ip); 
        	System.out.println("******************************************************************");
			
							   }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
