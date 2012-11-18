package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;


public interface I_Hello extends Remote   //需要从Remote继承
{
       public void setHashMap(HashMap<String,Integer> userPort) throws RemoteException;   //需要抛出remote异常
       public HashMap<String,Integer> getHashMap() throws RemoteException;
       
}