
public class MinHeap {
	public int[] array = new int[10]; // initial size of array is 10
	private int size;
	
	//create empty heap
	public MinHeap() {
		
	}
	//create heap from arrays
	public MinHeap(int[] inputArray) {
		size = inputArray.length-1;
		array = inputArray;
		/*
		 * Heapify starts from the last non-leaf node
		 * last non-leaf node = [last node(aka last leaf node)]/2
		 * 
		 * then decrement and Heapify the other non leaf nodes up until the root!
		 * 
		 * */
		for(int i=size/2; i>=0; i--) { 
			percolateDown(i);
		}
	}
	
	public void insert(int value) {
		size++; //increase the size
		if (size == array.length) { // if the size is equal to the length of array then create new array with double size and copy elements
			int[] newArray = new int[size*2];
			for (int i=1; i<size;i++) {
				newArray[i]=array[i]; //copied elements
			}
			array=newArray; //set the new array to be the array in the heap
		}
		array[size] = value; //insert at the end of the array then perculate Up!
		percolateUp(size);
	}
	
	/*
	 * remove the min value of the heap which is always the first value of the heap
	 * 
	 * */
	public int removeMin() {
		int min = array[1];
		array[1] = array[size];
		size--;
		percolateDown(1);
		return min;
	}
	
	public void percolateDown(int index) {
		int percolatingValue = array[index];
		//can't percolate down leaf nodes cause they have no children so bound it
		while (index*2<=size) {
			/*
			 * Swap the value at the index with its left child IF:
			 * 
			 * The percolating node's value is greater than the left child 
			 * AND the left child is a leaf node 
			 * 
			 * -OR-
			 * 
			 * The percolating node's value is greater than the left child's value
			 * AND the left child's value is less than or equal to the right child's value
			 * 
			 * IF neither of the conditions are met check Else If conditions
			 * 
			 * */
			if ((percolatingValue > array[index*2]) && (index*2 == size || array[index*2]<= array[index*2+1])) {
				array[index] = array[index*2];
				index = index*2;
			
			/*
			 * Swap the value at the index with its right child IF:
			 * 
			 * the percolating node's value is greater than its right child's value
			 * 
			 * */
	
			} else if (index*2<size && percolatingValue > array[index*2+1]) {
				array[index]=array[index*2+1];
				index = (index*2)+1;
			} else {
				break;
			}
		}
		array[index] = percolatingValue;
		
	}
	
	public void percolateUp(int index) {
		int percolatingValue = array[index]; //storing the value to be shifted downward
		/*
		 * while index is still greater than 1 
		 * AND the percolating value is less than its parent
		 * 
		 * SWAP the percolating node's value with its parent's value
		 * 
		 * */
		
		while (index > 1 && array[index/2]>percolatingValue) {
			array[index]= array[index/2];
			index/=2;
		}
		array[index] = percolatingValue; //set the percolating value at the stopping index
	}
	
	public void printHeap(){
		int nodeMax = 1;	
		for (int i = 1; i<=size; i++) {
			if (i == nodeMax) {
				System.out.println();
				nodeMax*=2;
			}
			
			System.out.print("[" + array[i] + "] ");
		}
	}	

}
