package test;

import java.net.*;
import java.io.*;


public class IMServer extends Thread {

	 Socket soc;
	 static ServerSocket serSoc;
	 
	 //constructor IMServer();
	  IMServer(Socket soc){
		 
		 this.soc=soc;
	 }
	 
	 
	 //run()
	 public void run(){
		 try{
			 InputStream in=soc.getInputStream();
			 PrintWriter out=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
			 out.println("hello client...");
			 out.flush();
			 
			 
			 byte [] buf=new byte[100];
			 int readByte;
			 
			 while((readByte=in.read(buf))>0){
				 System.out.println(new String(buf, 0, readByte));
				 out.println("fromServer...");
				 out.flush();
			 }
			 
			 
			 
			 
			 in.close();
			 out.close();
			 soc.close();
			 
		 }
		 catch(IOException e){System.err.println(e);}
		 
		 
	 }
	 
	 
	 //server() to accept and create socket, and also bind a port to the server
	 
	  public static void server(int serPort) {
		   try{
			    serSoc=new ServerSocket(serPort);
			   System.out.println("this:"+serSoc.getLocalPort());
			   while(true){
				   Socket s=serSoc.accept();
				   new IMServer(s).start();
			   }
			   
		   }catch(IOException e){System.err.println(e);}
		   
		   
		   
	   }
	    
	 
	 
	
	
}
