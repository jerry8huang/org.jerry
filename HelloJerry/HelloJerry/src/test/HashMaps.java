package test;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Hashtable;
import java.util.TreeMap;
@SuppressWarnings("unused")
class  HashMaps
{
       public static void main(String[] args)
      {
            Map<String,String> map=new HashMap<String,String>();           
            map.put("a", "aaa");
            map.put("b", "bbb");
            map.put("c", "ccc");
            map.put("k", "kkk");
            map.put("d", "ddd");
          
            Iterator<String> iterator = map.keySet().iterator();           
            while (iterator.hasNext()) {
             Object key = iterator.next();
             System.out.println("map.get(key) is :"+map.get(key));
            }      
           
           
           
            Hashtable<String, String> tab=new Hashtable<String, String>();           
            tab.put("a", "aaa");
            tab.put("b", "bbb");
            tab.put("c", "ccc");
            tab.put("d", "ddd");
            Iterator<String> iterator_1 = tab.keySet().iterator();
            while (iterator_1.hasNext()) {
             Object key = iterator_1.next();
             System.out.println("tab.get(key) is :"+tab.get(key));
            }        
           
            /*Hashtable输出是没有顺序的，而hashmap和treemap则是按key顺序排列的哦！！*/
            TreeMap<String, String> tmp=new TreeMap<String, String>();           
            tmp.put("a", "aaa");
            tmp.put("b", "bbb");
            tmp.put("c", "ccc");
            tmp.put("k", "888");
            tmp.put("d", "ddd");
            Iterator<String> iterator_2 = tmp.keySet().iterator();
            while (iterator_2.hasNext()) {
             Object key = iterator_2.next();
             System.out.println("tmp.get(key) is :"+tmp.get(key));
            }        
                     
        
       }
    
} 