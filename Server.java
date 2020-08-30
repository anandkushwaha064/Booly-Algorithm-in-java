import java.io.*;
import java.net.*; 
import java.util.*; 
 
public class Server
{
 private int num;
 
    public static void main(String[] args)
    {
	int j;
	int i=0;
	int n;
	Scanner s = new Scanner(System.in);
	String user[]=new String[40];
	String memory[]=new String[40];
	String ram;
	long ra[]=new long[40];
	long te;
	String ip[]=new String[40];
	String temp;
	Socket socket[]= new Socket[40];
	String CPU[]= new String[40];
        try
        {
			 try {
				 System.out.println("************ Modifed bully Algorithm **************");
			System.out.print("Enter Number of Nodes : ");
			n = s.nextInt();
		
 	        int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");
            //Server is running always. This is done using this while(true) loop
            while(i<n)
            {
		
                //Reading the message from the client
                socket[i] = serverSocket.accept();
				System.out.println(socket[i]);
                InputStream is = socket[i].getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
               
				user[i] = br.readLine();
				memory[i] = br.readLine();
				ram= br.readLine();		
				ip[i]= br.readLine();
                String returnMessage;
 		 
		//Sending the response back to the client.
                OutputStream os = socket[i].getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
				returnMessage = " We got your Configuration '"+user[i]+"'"+"\n";
                bw.write(returnMessage);
                System.out.println("\nNew Configuration found\n");
                bw.flush();
		 		ra[i]=Long.parseLong(ram);
i++;
 }


	System.out.print("\n--------------------\n");

	for(j=0; j<n; j++)
		{
		System.out.println("User name "+user[j]);
		System.out.println("Memory    "+memory[j] );
		System.out.println("Ram       "+ra[j] );	
		System.out.println("IP4 Address  "+ip[j]);		
	 	System.out.print("\n--------------------\n");
		}
	for( i=0; i<n; i++)
	{
	   for(j=i+1; j<n; j++)
	   {
		if(ra[i]<ra[j])
		{
		te=ra[i];
		ra[i]=ra[j];
		ra[j]=te;
		temp=user[i];
		user[i]=user[j];
		user[j]=temp;
		temp=ip[i];
		ip[i]=ip[j];
		ip[j]=temp;
		}
	    }
	}		
	System.out.print("Coordinator is " + user[0]+"\n");	


for(i=0; i<n; i++)
{
			System.out.println(socket[i]);
			OutputStream os = socket[i].getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
			String sendMessage = user[0] + "\n";
            bw.write(sendMessage);
	 		sendMessage = ip[0] + "\n";
            bw.write(sendMessage);
            bw.flush();
        //    System.out.println("Message sent to the server : "+sendMessage); 
}
}
	 catch (InputMismatchException e) {
            System.out.println("You have entered invalid data");
        }
}
        	
        catch (Exception e)
        {
            e.printStackTrace();
			System.out.println("You have entered invalid data");
        }
		
        finally
        {
            try
            {
				
			}
            catch(Exception e){
				
			}
        }
    }
}