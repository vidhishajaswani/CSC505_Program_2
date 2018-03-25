import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;



class Elements{
	int value;
	int index;
	Elements(int a, int b){
		this.value = a;
		this.index = b;
	}
}
public class quickselect {

	static int comparisons=0;
	static Integer x, y;

	int giveCorrectIndex(int arr[], int a, int b){
		int pivotIndex = 0;

		if((b-a+1) < 9){
			pivotIndex = b;
		}
		else{
			ArrayList <Elements> em = new ArrayList<Elements>();
			em.add(new Elements(arr[a], a));
			em.add(new Elements(arr[b], b));
			em.add(new Elements(arr[a+(b-a)/2], a+(b-a)/2));

			Collections.sort(em, new Comparator<Elements>(){
			          //@Override
			          public int compare(Elements a, Elements b){
									if(a.value > b.value){
										return 1;
									}else{
										return -1;
									}
			          }
			        });
			int[] valueArray = new int[3];
			int[] indexArray = new int[3];
			int i = 0;
			for(Elements e : em){
				valueArray[i] = e.value;
				indexArray[i] = e.index;
				i++;
			}

			//System.out.println("before :" + Arrays.toString(arr));
			int indexToBeSwapped = indexArray[1];
			//int indexToBeSwapped = a+(b-a)/2;
			int temp = arr[b];
			arr[b] = arr[indexToBeSwapped];
			arr[indexToBeSwapped] = temp;
			//System.out.println("after :" + Arrays.toString(arr));
			pivotIndex = b;
		}
		int temp = 0;
		int i = a - 1;
		for(int j = a; j < b; j++){
			if(arr[j] < arr[pivotIndex]){
				//System.out.println("a[j]  :" +arr[j]);

				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//System.out.println("a  :" +a+" val of a: "+arr[a]+"  b: "+b+"  val of b: "+arr[b]);
		//System.out.println("b-a/2"+(b-a)/2);

		//System.out.println("pivot  :" +arr[pivotIndex]);
		temp = arr[i+1];
		arr[i+1] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		//System.out.println("pivot swapp :" + Arrays.toString(arr));
		//System.out.println("pivot  :" +arr[pivotIndex]);


		return i + 1;


	}

	int quickselect(int arr[], int a, int b){
		int medianIndex = (arr.length-1)/2;
		if(a <= b){
			int index = giveCorrectIndex(arr, a, b);

			if(index == medianIndex){
				return index;
			}
			else if(index > medianIndex){
				return quickselect(arr, a, index - 1);
			}else{
				return quickselect(arr, index + 1, b);
			}
		}
		return -1;

	}

	public static void main(String args[])
	{
		Scanner inputScanner = new Scanner(System.in);
		ArrayList <Integer> input = new ArrayList<Integer>();
		int n = 0;
		while (inputScanner.hasNext()){
			input.add(new Integer(inputScanner.nextInt()));
			n++;
		}
		inputScanner.close();
		int[] arr= new int[n];
		int i = 0;
		for(Integer intobject : input){
			arr[i++] = intobject.intValue();
		}
		quickselect qs = new quickselect();
        long startTime = System.currentTimeMillis();
		int index=qs.quickselect(arr, 0, n-1);
        long endTime = System.currentTimeMillis();

        long elapsedTime = endTime - startTime;

        if(elapsedTime > Integer.MAX_VALUE)
        {
          throw new IllegalArgumentException(elapsedTime + "cannot convert to int without modifying value");
        }
        int runtime = (int) elapsedTime;
		//System.out.println("main :" + Arrays.toString(arr));

		System.out.println("median," + arr[index]);
		System.out.println("index," + index);
		
        System.out.println("runtime," + runtime);


		//System.out.println(Arrays.toString(arr));
	}
	
	//overridden function compareTo that increments the global counter
	public static int compare(int l,int r)
	{
		comparisons++;
		x = Integer.valueOf(l);
		y = Integer.valueOf(r);
		return x.compareTo(y);
	}



}