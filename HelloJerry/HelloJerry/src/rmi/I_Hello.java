package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;


public interface I_Hello extends Remote   //��Ҫ��Remote�̳�
{
       public void setHashMap(HashMap<String,Integer> userPort) throws RemoteException;   //��Ҫ�׳�remote�쳣
       public HashMap<String,Integer> getHashMap() throws RemoteException;
       
}