package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface I_Hello extends Remote   //需要从Remote继承
{
       public String SayHello() throws RemoteException;   //需要抛出remote异常
}