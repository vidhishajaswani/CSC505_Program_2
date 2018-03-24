import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quickselect {

<<<<<<< HEAD
	int partition(int arr[], int a, int b){
		int pivotIndex = 0;
=======
        //Parse length of array from first line
        ArrayList <Integer> input = new ArrayList<Integer>();
        int length = 0;
        while (inputScanner.hasNext()){
          input.add(new Integer(inputScanner.nextInt()));
          length++;
        }
        int[] myArray= new int[length];
        inputScanner.close();
        
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
>>>>>>> 69567dcbda38d65a59f3fc0f0ce2a83d48fbf9b3

		//Pivot Selection
		if((b-a+1) < 9){
			pivotIndex = a;
		}else {
			int middle = (b-a)/2;

			if(arr[a]>arr[b]){
				if(arr[middle]>arr[a]){
					pivotIndex = a;
				}else if(arr[middle]>arr[b]){
					pivotIndex = middle;
				}else{
					pivotIndex = b;
				}
			}else{
					if(arr[middle]>arr[b]){
						pivotIndex = b;
					}else if(arr[middle]>arr[a]){
						pivotIndex = middle;
					}else{
						pivotIndex = a;
					}
			}
		}
		//Quicksort begins
		int pivot = arr[pivotIndex];
		int i = a - 1;
		for(int j = a; j < b; j++){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[b];
		arr[b] = temp;
		return i+1;

	}

	int quickselect(int arr[], int a, int b){
		int medianIndex = (arr.length+1)/2;
		if(low < high){
			int index = partition(arr, a, b);
			if(index == (medianIndex)){
				return index;
			} else if(index > medianIndex){
				return quickselect(arr, a, medianIndex - 1);
			}else{
				return quick_select(arr, medianIndex + 1, b);
			}

		}

	}
	public static void main(String args[])
	{
		int arr[] = {10, 7, 8, 9, 1, 5};
		int n = arr.length;
		int answer = quickselect(arr, 0, n-1);

	}



}
