
public class main {
	public static void main(String args[]) {
		int myArray2[] = {1,2,5,6,7,3,8,4};
		MinHeap heapArray = new MinHeap(myArray2);
		heapArray.insert(19);
		heapArray.insert(0);
		heapArray.printHeap();
	}

}
