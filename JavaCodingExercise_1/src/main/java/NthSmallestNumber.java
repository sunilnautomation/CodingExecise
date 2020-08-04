import java.io.Console;
import java.util.Collections;
import java.util.Random;

public class NthSmallestNumber {
    static final int randomNumberCount=500;

    /* Method to generate 500 random number */
    public static Integer[] generateRandomNumbers() {
        Integer randomNumbers[] = new Integer[randomNumberCount];
        Random rand = new Random();
        System.out.println("Automatically generated "+ randomNumberCount +" random numbers are:: \n");

        System.out.print("[ ");
        for (int i = 0; i < randomNumberCount; i++) {
            randomNumbers[i] = rand.nextInt();
            System.out.print(randomNumbers[i]);
            System.out.print(" ");
        }
        System.out.print("]");

        return randomNumbers;
    }

    /* Method to return n'th smallest element from arr[l..r] using QuickSelect based method. */
    public static int kthSmallest(Integer[] arr, int left, int right, int n) {
        if (n > 0 && n <= right - left + 1) {
            int pos = partition(arr, left, right);
            if (pos - left == n - 1)
                return arr[pos];

            if (pos - left > n - 1)
                return kthSmallest(arr, left, pos - 1, n);

            return kthSmallest(arr, pos + 1, right, n - pos + left - 1);
        }
        return Integer.MAX_VALUE;
    }

    /* Method to do Partition process of QuickSort considering the last element as pivot
    and moving all smaller element to left of it and greater elements to its right */
    public static int partition(Integer[] arr, int left, int right) {
        int x = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] <= x) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }


    /* Main method to invoke the method to find the nth smallest */
    public static void main(String[] args) {

        Integer arr[] = generateRandomNumbers();

        //Obtaining a reference to the console.
        Console con = System.console();

        // Checking If there is no console available, then exit.
        if (con == null) {
            System.out.print("No console available");
            return;
        }

        try {
            // Read the user choice of nth smallest from console
            String nthsmallestNumber = con.readLine("\n\nEnter your choice to find nth smallest from the generated random numbers but a number between 1 and 500 only :: ");
            if (nthsmallestNumber == null || nthsmallestNumber.length() == 0) {
                System.out.println("\n<Your choice shouldn't be empty>\n");
                return;
            } else if (!(Integer.parseInt(nthsmallestNumber) >= 1 && Integer.parseInt(nthsmallestNumber) <= 500)) {
                System.out.println("\n<Your choice should be within the range of 1 and 500 only>\n");
                return;
            }

            // Print the request nth smallest number
            System.out.println("\nThe requested (" + nthsmallestNumber + ")th/nd/st smallest number is :: " + kthSmallest(arr, 0, arr.length - 1, Integer.parseInt(nthsmallestNumber)) + "\n");
        }catch (Exception e){
            System.out.println("\n<Your choice should be within the range of 1 and 500 only>\n");
            return;
        }
    }
}
