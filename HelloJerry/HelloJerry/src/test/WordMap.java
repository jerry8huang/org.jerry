package test;

import java.util.HashMap;
import java.io.*;
import java.util.*;

public class WordMap {

 

    public static void main(String[] args) throws Exception {
    	char[] charBuf=new char[10];
    	
    	ArrayList<String> input=new ArrayList<String>();
    	FileReader FrIn=new FileReader(args[0]);
    	while(FrIn.read(charBuf)>0){
    		
    	input.add(new String(charBuf));
    		}
    	FrIn.close();
       //String input = "a1,b2,3c,d4d,a1,b2,a1";
    	String inFile=input.toString();
        String[] ws = inFile.split(",");
    	 

//鍋氱殑鍗曡瘝鍒嗗壊锛�
//濡傛灉浣犺绌烘牸鍒嗗壊 String[] ws = input.split(" ");

       HashMap<String,Integer> hm = new HashMap<String, Integer>();

//鍒濆鍖朒ashMap

       for(String s:ws)

       {

           if(s.matches("[a-zA-Z]\\w+"))

//杩欓噷鏄竴涓鍒欒〃杈惧紡锛屽垽鏂殑鏄涓�釜蹇呴』鏄瓧姣嶏紝鍚庨潰鐨勬槸涓�釜瀛楁瘝鎴栧涓瓧姣嶏紝涓�釜//鏁板瓧鎴栧涓暟瀛�
           {
        	  System.out.println("s is:"+s);
              Integer cou = hm.get(s);
              System.out.println("cou is:"+cou);

//get()鏂规硶灏嗕骇鐢熶竴涓笌閿浉鍏宠仈鐨処nteger鍊硷紝鐒跺悗杩欎釜鍊艰閫掑锛屼负鐨勬槸璁板綍鏍囪瘑绗︾殑//涓暟

              hm.put(s, cou == null?1:cou+1);

//淇濆瓨鍒癏ashMap涓互鍗曡瘝鍋歬ey,鍒ゆ柇鍗曡瘝鏄惁涓虹┖锛岀┖涓�锛屾垨鍒欏姞1

           }

       }
      // hm.remove("b2");
       System.out.println(hm);

//鎵撳嵃HashMap

    }

    
}