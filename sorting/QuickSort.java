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

public class Quicksort
{
    public static void Sort(UserObject[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            Sort(arr, low, partitionIndex - 1);
            Sort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(UserObject[] arr, int low, int high) {
        UserObject pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getValue() < pivot.getValue()) {
                i++;

                // Swap arr[i] and arr[j]
                UserObject temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        UserObject temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
        Sort(obj,0,n-1);

        for(UserObject it: obj)
        {
            System.out.print(it.getValue()+ " ");
        }
    }
}