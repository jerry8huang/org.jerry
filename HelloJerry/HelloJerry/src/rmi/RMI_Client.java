package rmi;

import java.rmi.*;
public class RMI_Client {
    public static void main(String[] args) {
        try
        {
           I_Hello hello = (I_Hello) Naming.lookup("//192.168.1.151:1099/RMI_Hello"); //通过RMI名称查找远程对象
            System.out.println(hello.getHashMap());                        //调用远程对象的方法
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

}
