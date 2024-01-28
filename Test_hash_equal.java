import java.util.*;
class Test_hash_equal{  
    public static void main(String[] args){  
        String a = "Hrithik";  
        String b = "Hrithik";  
  
        if(a.equals(b))
        {   
            System.out.println("a & b are equal variables, and their respective hashvalues are:" + " "+ a.hashCode() + " & " + b.hashCode());  
          
        }  
  
        String c = "Satvik";  
        String d= "Pratham";  
  
        if(!c.equals(d))
        {     
            System.out.println("\nc & d are Un-equal variables, and their respective hashvalues are:" + " "+ c.hashCode() + " & " + d.hashCode());  
              
        }  
    }  
}  