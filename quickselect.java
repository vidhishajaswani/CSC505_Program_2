import java.util.Arrays;

public class quickselect {
		
	public static void main(String args[])
	{
		int myArray[]= new int[] {10,4,5,8,6,11,26,1,2};
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
        float runtime_ins =  elapsedTime;
		System.err.println("median,"+output);
		System.err.println("runtime,"+runtime);

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
				myLeft++;
			
			while(myRight>left && myArray[myRight]>pivot)
				myRight--;
			
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
