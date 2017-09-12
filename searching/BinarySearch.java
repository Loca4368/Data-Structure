/*
 * Description: Implementation on Binary Search
 * Author:Ming
 * 
 */
package searching;

public class BinarySearch {
	
	int[] array ={3,8,10,20,25,31,38,40,44,47,50,52};
	
	public int binarySeach(int target)
	{
		int head,tail,mid;
		
		//set head to be the first index of array
		head = 0;
		
		//set tail to be the last index of array
		tail = array.length -1;
		
		while(head<=tail)
		{
			//get the mid index
			mid = (head + tail)/2;
			
			//If match the target
			if(array[mid] == target)
			{
				return mid;
			}
			//target in the first half
			else if(array[mid] > target)
			{
				tail= mid -1; 
			}
			else
			{
				head= mid + 1;
			}
				
		}
		
		//Not found
		return -1;
	}
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		
		System.out.print("Target element is found at:"+bs.binarySeach(50));
	}

}