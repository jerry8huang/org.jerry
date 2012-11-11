package rmi;

//import java.io.PrintStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject   //必须从UnicastRemoteObject 继承
                   implements I_Hello
{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Hello() throws RemoteException     //需要一个抛出Remote异常的默认初始化方法
        {
        }

        public String SayHello()     //这个是实现I_Hello接口的方法
        {
           return "Hello world !!";
        }
}