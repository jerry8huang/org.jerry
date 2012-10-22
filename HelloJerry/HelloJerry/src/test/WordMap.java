package test;

import java.util.HashMap;



public class WordMap {

 

    public static void main(String[] args) {

       String input = "a1,b2,3c,d4d,a1,b2,a1";

       String[] ws = input.split(",");

//做的单词分割，

//如果你要空格分割 String[] ws = input.split(" ");

       HashMap<String,Integer> hm = new HashMap<String, Integer>();

//初始化HashMap

       for(String s:ws)

       {

           if(s.matches("[a-zA-Z]\\w+"))

//这里是一个正则表达式，判断的是第一个必须是字母，后面的是一个字母或多个字母，一个//数字或多个数字

           {
        	  System.out.println("s is:"+s);
              Integer cou = hm.get(s);
              System.out.println("cou is:"+cou);

//get()方法将产生一个与键相关联的Integer值，然后这个值被递增，为的是记录标识符的//个数

              hm.put(s, cou == null?1:cou+1);

//保存到HashMap中以单词做key,判断单词是否为空，空为1，或则加1

           }

       }
      // hm.remove("b2");
       System.out.println(hm);

//打印HashMap

    }

    
}