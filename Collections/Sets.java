package Collections;

import java.util.*;
    
public class Sets{
    public static void Hash()
    {
        HashSet<String> str= new HashSet<String>();
    
        System.out.println("Size at the beginning "+str.size());
        
        //add elements
        str.add("Hello");
        str.add("Hi");
        str.add("Namaste");
        str.add("Bonjour");
        
        System.out.println(str);
        System.out.println("Size after addition "+str.size());
        
        str.remove("Bonjour");
        
        System.out.println(str);
        
        System.out.println("Size after removal "+str.size()); 
    }
    public static void Trees()
    {
            
            Set<String> ts = new TreeSet<>();
            System.out.println("\n\nTREESET");
            System.out.println("Size at the beginning "+ts.size());
            ts.add("Biology");
            ts.add("Mathematics");
            ts.add("English");
    
            System.out.println(ts);
            System.out.println("Size after addition "+ts.size());
        
     
            // Duplicates are not inserted into the TreeSet
            ts.add("Biology");
     
            // Elements get stored in Ascending order
            System.out.println(ts);
        
    }
    
    
    public static void main(String args[]){
    //HashSet
    Hash();
    Trees();
        
    }
    }

