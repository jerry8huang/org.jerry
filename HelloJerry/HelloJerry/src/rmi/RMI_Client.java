package rmi;

import java.rmi.*;
public class RMI_Client {
    public static void main(String[] args) {
        try
        {
           I_Hello hello = (I_Hello) Naming.lookup("//192.168.1.151:1099/RMI_Hello"); //ͨ��RMI���Ʋ���Զ�̶���
            System.out.println(hello.getHashMap());                        //����Զ�̶���ķ���
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

}
