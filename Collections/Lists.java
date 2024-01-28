package Collections;

import java.util.*;  
class TestJavaCollection1{  
public static void main(String args[]){  
ArrayList<String> list=new ArrayList<String>();
list.add("Mango");//Adding object in arraylist  
list.add("apple");  
list.add("Peach");  
//Traversing list through Iterator  
Iterator itr=list.iterator();  
while(itr.hasNext()){  
System.out.println(itr.next()); 
}
ArrayList<String> names=new ArrayList<String>(Arrays.asList("hrithik","Satvik","pratham")); 
Iterator newitr=names.iterator();  
while(newitr.hasNext()){  
System.out.println(newitr.next()); 
}  
names.remove(0);//Removes 'hrithik' from names

//LINKED LIST

    
    LinkedList<String> coding= new LinkedList<String>();
    

    System.out.println("Size at the beginning "+list.size());
    
    //add elements
    coding.add("Java");
    coding.add("C++");
    coding.add("JavaScript");
    coding.addFirst("C#");
    coding.addLast("Kotlin");
    
    coding.add(2,"Python");

    System.out.println("Original Linked List " + coding);
    System.out.println("Size after addition "+coding.size());
    
    coding.remove(5);
    coding.remove("C#");

    System.out.println("New Linked List "+ coding);
    System.out.println("Size after removal "+coding.size());
   

}  
} 
 