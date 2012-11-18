package test;

import java.net.*;
import java.io.*;
import java.rmi.RemoteException;
import java.util.*;
import rmi.Hello;

/**
 * This(IMServer) is a component of a IM system which is composed of following component:
 * IMServer:
 * 
 * NetClient:
 * 
 * subClient:
 * 
 * NetClient02:
 * 
 * 
 * */

public class IMServer  {

	 //main() start the IMServer
	
	
	
	
	 ServerSocket serSoc;
     //save userName and cliSerPort with HashMap userPort
     public HashMap<String,Integer> userPort=new HashMap<String,Integer>();
  
	 synchronized void put(String key, Integer value){
		 
		 userPort.put(key, value);
	 }
	 
	 synchronized void remove(String key){
		 
		 userPort.remove(key);
	 }
	 
	 
     
      class thread_IMSer extends Thread{

         Socket soc;

         thread_IMSer(Socket soc){

           this.soc=soc;
         }

           //run() to handle input from client and save it
	 public void run(){
		 try{
			 InputStream in=soc.getInputStream();
			 PrintWriter out=new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
			 
			 //output object userPort(HashMap<String,Integer>)
			 //ObjectOutputStream outObj=new ObjectOutputStream(soc.getOutputStream());
			 
			 out.println("hello client,this is IMServer");
			 out.flush();
			 
			
			 String token;
			 String []subTok=new String[2];
			 
			 byte [] buf=new byte[100];
			 int readByte;
			 
			//save userName and cliSerPort with HashMap userPort
			 readByte=in.read(buf);
			 token=new String(buf, 0, readByte);
			 subTok=token.split(":");
			 System.out.println(token);
			 
			
			
			 
			 put(subTok[0], Integer.parseInt(subTok[1]));
			 
			 
			 
			 //reply client with message "IMServer got it."
			 while((readByte=in.read(buf))>0){
				 
				 
				 
			 
			
			 //remove userName from HashMap userPort if userName's client closed
			 //otherwise print available userName.
			 if(!soc.isConnected()){
				 
				 remove(subTok[0]);
			 }
			 else{
				 
				 //System.out.println(userPort.entrySet());
				 out.println("IMServer got it."+"\n"+userPort.entrySet());
				 out.flush();
				 //outObj.writeObject(userPort);
				 //outObj.flush();
			 }
			 }
			 
			 in.close();
			 out.close();
			 //outObj.close();
			 soc.close();
			 
		 }
		 catch(IOException e){System.err.println(e);}
		 
		 
	 }


     };
	
	 
	 
	 //server() to accept and create socket, and also bind a port to the server
	 
	  public  void server(int serPort) {
		   try{
			    serSoc=new ServerSocket(serPort);
			   System.out.println("IMServer:"+serSoc.getLocalPort());
			   while(true){
				   Socket s=serSoc.accept();
				   new thread_IMSer(s).start();
				  
			   }
			   
		   }catch(IOException e){e.printStackTrace();}
		  
		   
		   
		   
	   }
	    
	 
	 
	
	
}
