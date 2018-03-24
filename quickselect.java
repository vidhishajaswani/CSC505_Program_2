import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quickselect {

	int partition(int arr[], int a, int b){
		int pivotIndex = 0;

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
