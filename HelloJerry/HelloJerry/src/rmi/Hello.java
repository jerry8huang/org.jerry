package rmi;

//import java.io.PrintStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject   //�����UnicastRemoteObject �̳�
                   implements I_Hello
{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public Hello() throws RemoteException     //��Ҫһ���׳�Remote�쳣��Ĭ�ϳ�ʼ������
        {
        }

        public String SayHello()     //�����ʵ��I_Hello�ӿڵķ���
        {
           return "Hello world !!";
        }
}