package rmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import test.IMServer;
public class RMI_Server
{ 
    public static void main(String[] args)
    {
        try
        {
        	
        	LocateRegistry.createRegistry(1099); //start Registry service
            final Hello hello = new Hello();                //实例化要发布的类
            Naming.rebind("RMI_Hello", hello);      //绑定RMI名称 进行发布
            
            

     	   final IMServer imSer=new IMServer();	
            
            
            Thread thread_HashMap =new Thread(){
         	   
         	   public void run(){
         		   hello.setHashMap(imSer.userPort);
				   System.out.println("HashMap........");
         			 
         	   }
         	   
            };
             
            thread_HashMap.start();
            
            System.out.println("=== Hello server Ready === ");
            
            imSer.server(8889);
         
            
            
            
            
           
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    } 
}
