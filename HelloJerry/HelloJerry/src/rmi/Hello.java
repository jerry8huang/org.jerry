package rmi;

//import java.io.PrintStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Hello extends UnicastRemoteObject   //�����UnicastRemoteObject �̳�
                   implements I_Hello
{
	
	
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private HashMap<String,Integer> userPort;
		public Hello() throws RemoteException     //��Ҫһ���׳�Remote�쳣��Ĭ�ϳ�ʼ������
        {
        }

		public void setHashMap(HashMap<String,Integer> userPort){
			this.userPort=userPort;
			
		}
		
        public HashMap<String,Integer> getHashMap()    //�����ʵ��I_Hello�ӿڵķ���
        {
           	
           return userPort;
        }
}