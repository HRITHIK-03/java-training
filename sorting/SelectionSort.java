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

public class SelectionSort
{
    public static void Sort(UserObject[] arr)
    {
        int n=arr.length;
          
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].getValue() < arr[minIndex].getValue()) {
                    minIndex = j;
                }
            }

            // Swapping the minimum element with the current element
            UserObject temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
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
