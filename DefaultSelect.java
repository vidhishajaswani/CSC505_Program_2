import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;


public abstract class DefaultSelect implements Comparable<Integer>
{
    static int comparisons=0;   //global variable to store number of comparisons
    public static void main(String[] args) 
    {
        //take input from standard input
        Scanner inputScanner = new Scanner(System.in);
        ArrayList <Integer> input = new ArrayList<Integer>();
        int length = 0;
        while (inputScanner.hasNext())
        {
          input.add(new Integer(inputScanner.nextInt()));
          length++;
        }
        int[] myArray= new int[length];
        inputScanner.close();
       
        //Record system time at start
        long startTime = System.currentTimeMillis();

        //overidden function that uses the compare To function and increments the counter
        Collections.sort(input, new Comparator<Integer>()
        {
          //@Override
          public int compare(Integer a, Integer b){
            comparisons++;
            return a.compareTo(b);
          }
        });

        //Record system time at end
        long endTime = System.currentTimeMillis();
        
        //Difference is elapsed time and convert to integer.
        long elapsedTime = endTime - startTime;
        
        //Check to see if long goes over max integer value
        if(elapsedTime > Integer.MAX_VALUE)
        {
          throw new IllegalArgumentException(elapsedTime + "cannot convert to int without modifying value");
        }
        
        //Typecast to integer and write to variable
        int runtime = (int) elapsedTime;
        

        //converting Integer objects to int array which is now sorted.
        int i = 0;
        for(Integer intobject : input){
          myArray[i++] = intobject.intValue();
        }
        
        int kIndex = (myArray.length - 1)/2;
        System.out.println("median," + myArray[kIndex]);
        System.out.println("runtime," + runtime);
        System.out.println("comparisons," + comparisons);
    }
}
