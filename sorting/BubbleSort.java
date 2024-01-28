import java.util.*;

class UserObject
{
    int value;
    public UserObject(int value)
    {
        this.value=value;
    }
    public int getValue()
    {
        return value;
    }
}

public class BubbleSort
{
    public static void Sort(UserObject[] arr)
    {
        int n=arr.length;
          
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] .getValue() > arr[j].getValue()){  
                                 //swap elements  
                                 UserObject temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
    }
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the freq. of the numbers");
        int n=ob.nextInt();

        UserObject[] obj=new UserObject[n];

        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the number "+(i+1)+": ");
            int val=ob.nextInt();
            obj[i]=new UserObject(val);
        }
        Sort(obj);

        for(UserObject it: obj)
        {
            System.out.print(it.getValue()+ " ");
        }
    }
}