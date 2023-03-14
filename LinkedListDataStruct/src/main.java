
public class main {
	
	//Search Algorithms
	
	//Linear Search for Array of integers
	public static int linearSearch(int arr[], int value) {
		int returnIndex=-1;
		for (int i =0; i<arr.length-1;i++) {
			if(arr[i]==value) {
				returnIndex = i;
				return returnIndex;
			}
		}
		
		return returnIndex;
	}
	
	//Binary Search
	//Preconditions: Must be a sorted list/array
	public static int binarySearch(int arr[], int value) {
		//base case
		if (arr[0]==value) {
			return arr[0];
		}
		if (arr[arr.length-1]==value) {
			return arr[arr.length-1];
		}
		else return binarySearchRecursion(arr,0,arr.length-1,value);
	}
	
	public static int binarySearchRecursion(int arr[], int start, int last, int value) {
		int mid = (last-start)/2;
		if (arr[mid]==value) {
			return arr[mid];
		}
		else if (value>arr[mid]) { //value is greater than midpoint? change range to mid+1 to last value and erase the lesser half
			return binarySearchRecursion(arr,mid+1,last,value);
		}else if (value<arr[mid]) { // value less than midpoint? change range to start value to one less than the mid point and narrow away from the upper half
			return binarySearchRecursion(arr,start,mid-1,value);
		}else return -1;
		
	}
	
	public static void main(String args[]) {
		int myArray[] = {1,2,3,4,5,6,7,9};
		int value = 12;
		int indexFound1 = linearSearch(myArray, value);
		int indexFound2 = linearSearch(myArray, value);
		System.out.println("The value: " + value + " was found in the array at index: " + indexFound1);
		System.out.println("The value: " + value + " was found in the array at index: " + indexFound2);
		
		LinkedList<Integer> myList = new LinkedList<Integer>();
		myList.add(0,1);
		myList.add(1,4);
		myList.add(2,3);
		myList.add(0,7);
		
		int indexInList = 0;
		int myElement = myList.get(indexInList);
		System.out.println("The value: " + myElement + " was found in the list at index: " + indexInList);
		myList.printList();
		
		boolean isInserted = myList.insertBefore(5,4);
		System.out.println(myList.size() + " " + isInserted);
		myList.printList();
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}