package rmi;

import java.rmi.*;
public class RMI_Client {
    public static void main(String[] args) {
        try
        {
           I_Hello hello = (I_Hello) Naming.lookup("RMI_Hello"); //ͨ��RMI���Ʋ���Զ�̶���
            System.out.println(hello.SayHello());                        //����Զ�̶���ķ���
        } catch (Exception e)
        {
          e.printStackTrace();
        }
    }

}
