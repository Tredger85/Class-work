/*CSD 211 HW3 problem 13 page 751
Andrew Franko 4/26/18
Take a map with key and mapped that are strings and confirm that 
each of the mapped isUnique. While some of the lines are somewhat 
complex(I really didnt expect for the keySet to work within a for-
each) but over all there are few lines of code.  As the nested for-
each work independently, I was careful that the same key did not trip
the equals of the mapped.*/


import java.io.*;
import java.util.*;

public class IsUnique{
    
    public static boolean isUnique(Map<String,String> map){
        //Cycle through the keys
        for(String key1: map.keySet()){
            //Cycle through the keys a second time
            for(String key2: map.keySet()){
                if(!key1.equals(key2)&&map.get(key1).equals(map.get(key2))){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Marty", "Stepp"); 
        map.put("Stuart", "Reges");
        map.put("Jessica", "Miller");
        map.put("Amanda", "Camp");
        map.put("Hal", "Perkins");
        System.out.println("Print of HashMap map: "+map);
        System.out.println("Print of isUnigue map: "+isUnique(map));
        map.put("Kendrick","Perkins");
        System.out.println("Print of HashMap map with one more to force fail: "+map);
        System.out.println("Print of isUnigue map v.2: "+isUnique(map));
    }
}