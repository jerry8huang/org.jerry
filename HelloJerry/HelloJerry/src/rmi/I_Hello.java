package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface I_Hello extends Remote   //��Ҫ��Remote�̳�
{
       public String SayHello() throws RemoteException;   //��Ҫ�׳�remote�쳣
}