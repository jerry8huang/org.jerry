package test;

import java.util.HashMap;
import java.io.*;

import java.lang.StringBuilder;

public class WordMap {

 

    public static void main(String[] args) throws IOException {

       //String inFile = "a1,b2,3c,d4d,a1,b2,a1";

       char[] charBuf=new char[1];//length of array should be 1, otherwise got strange issue.
       
       StringBuilder inStringB=new StringBuilder();
       
      //create fileReader FrIn to read characters from input file
       FileReader FrIn=new FileReader(args[0]);
       
      //read characters from input file to charBuf and append them to stringBuilder inStringB
       while(FrIn.read(charBuf)>0){
       //test* System.out.println(charBuf);
       inStringB.append(charBuf);
       }
         
       FrIn.close();
         
       String inFile=inStringB.toString();
       System.out.println(inFile); 
       String[] ws = inFile.split(",");
       //test* System.out.println("the last element of ws is:"+ws[ws.length-1]);

//做的单词分割，

//如果你要空格分割 String[] ws = inArrayL.split(" ");

       HashMap<String,Integer> hm = new HashMap<String, Integer>();

//初始化HashMap

       for(String s:ws)

       {

           //test* if(s.matches("[a-zA-Z]\\w+"))

//这里是一个正则表达式，判断的是第一个必须是字母，后面的是一个字母或多个字母，一个//数字或多个数字

           //{
        	  //System.out.println("s is:"+s);
              Integer cou = hm.get(s);
              //System.out.println("cou is:"+cou);

//get()方法将产生一个与键相关联的Integer值，然后这个值被递增，为的是记录标识符的//个数

              hm.put(s, cou == null?1:cou+1);

//保存到HashMap中以单词做key,判断单词是否为空，空为1，或则加1

           //}

       }
      // hm.remove("b2");
       System.out.println(hm);
       
       FileWriter FwOut=new FileWriter(args[1]);
       FwOut.write(hm.toString());
       FwOut.close();
       

//打印HashMap

    }

    
}