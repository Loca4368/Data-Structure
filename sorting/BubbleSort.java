/*
 * Description: Implement Bubble sort to sort array in ascending order
 * @Author:Ming
 */

package sorting;

import searching.BinarySearch;

public class BubbleSort {
	
	int[] array ={52,3,8,50,25,44,31,38,10,20,40,47};
	
	public void sort()
	{
		
		//Outer loop, determining the times of loops
		for(int flag = array.length -1;flag> 0;flag --)
		{
			
			//Inner loop, determining the elements to be compared for each loop
			for(int i=0;i<flag; i++)
			{
				//if greater
				if(array[i]>array[i+1])
				{
					//swap index if 
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}	
				
			}
			
		}
		
	}
	
	public void printArray()
	{
		for (int i=0; i<array.length;i++)
		{
			System.out.print(array[i]+",");
		}
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.sort();
		bs.printArray();
	}

}
