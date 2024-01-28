package Collections;

import java.util.*;
  
public class Maps {
    public static void main(String args[])
    {
        
        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
  
        //adding key value pairs using put()
        hm.put(1, 23.5);
        hm.put(2, 2.8);
        hm.put(3, 3.79);
  
        // Finding the value for a key using get()
        System.out.println("The Value for 1 is " + hm.get(1));
  
    }
}

