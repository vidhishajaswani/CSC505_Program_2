import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quickselect {
		
	static int comparisons=0;
	public static void main(String args[])
	{
		//int myArray[]= new int[] {10,4,5,8,6,11,26,1,2};
		
        Scanner inputScanner = new Scanner(System.in);

        //Parse length of array from first line
        ArrayList <Integer> input = new ArrayList<Integer>();
        int length = 0;
        while (inputScanner.hasNext()){
          input.add(new Integer(inputScanner.nextInt()));
          length++;
        }
        int[] myArray= new int[length];
        inputScanner.close();
        
        
        int i = 0;
        for(Integer intobject : input){
          myArray[i++] = intobject.intValue();
        }
        
		int k=(int) Math.floor((myArray.length+1)/2);
        long startTime = System.currentTimeMillis();
		int output=quick_select(myArray,0,myArray.length-1,k);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        if(elapsedTime > Integer.MAX_VALUE)
        {
            throw new IllegalArgumentException(elapsedTime + "cannot convert to int without modifying value");
        }
        int runtime = (int) elapsedTime;
        //float runtime_ins =  elapsedTime;
		System.out.println("median,"+output);
		System.out.println("runtime,"+runtime);
		System.out.println("comparisons,"+comparisons);

	}
	public static int quick_select(int myArray[],int left, int right, int k)
	{
		if(k>0 && k<=right-left+1)
		{
			if(left==right)
				return myArray[left];
			
			
			int myIndex=partition(myArray,left,right);
			int current=myIndex-left+1;
			if(current==k)
				return myArray[myIndex];
			
			else if(k<current)
			{
				return quick_select(myArray,left,myIndex-1,k);
			}
			else return quick_select(myArray,myIndex+1,right,k-current);
		}
		
		return 0;
		
	}
	public static int partition(int myArray[],int left,int right)
	{
		int pivot;
		if(myArray.length<9)
		{
			pivot=myArray[left];
		}
		else
		{
			int tempArray[]=new int[3];
			tempArray[0]=myArray[left];
			int mid=(right-left+1)/2;
			tempArray[1]=myArray[mid];
			tempArray[2]=myArray[right];
			Arrays.sort(tempArray);
			//System.out.println(Arrays.toString(tempArray));
			pivot=tempArray[1];
			
		}
		
		//pivot=myArray[left];
		
		int myLeft=left+1;
		int myRight=right;
		
		
		while(true)
		{
			while(myLeft<right && myArray[myLeft]<pivot)
			{
				myLeft++;
				comparisons++;
			}
			while(myRight>left && myArray[myRight]>pivot)
			{
				myRight--;
				comparisons++;
			}
			
			if(myLeft>=myRight)
				break;
			
			else
			{
				int temp=myArray[myLeft];
				myArray[myLeft]=myArray[myRight];
				myArray[myRight]=temp;
			}
				
			
		}
		int temp=myArray[left];
		myArray[left]=myArray[myRight];
		myArray[myRight]=temp;
		
		return myRight;
		
	}
	
}