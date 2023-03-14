
public class LinkedList<E> {
	int size;
	ListNode<E> head;
	
	//returns size! which is updated depending on the manipulation of the list
	public int size() {
		return size;
	}
	
	//add method
	public void add(int index, E data) {
		// if want to place in the front of the list, create new node and let that be the head! :D
		if (index==0) {
			head = new ListNode<E>(data,head); 
		} else { //traverse to the index where u want to attach the node
			ListNode<E> curr = head;//start at the head
			for (int i=0;i<index-1;i++) { //index-1 stops at the node before the stop it would be placed
				curr=curr.next;
			}
			curr.next = new ListNode<E>(data,curr.next);
		}
		//increase size of list! :D
		size++;
	}
	
	public E remove(int index){
		E data;//storing value to return later!
		ListNode<E> curr = head; //start at the head in the list
		if (index==0) {
			data = head.data;
			head = head.next; //head is now the next value
		} else {
			for (int i =0; i<index-1;i++) { // will endup at the node before the one to be removed!
				curr=curr.next;
			}
			data = curr.next.data; // retreive the data of the node to be deleted
			curr.next = curr.next.next; // will (curr)>(curr.next)>(curr.next.next)>(...) is now (curr)>(curr.next.next)>(...)
		}
		size--; // decrement size cause u removed a node
		return data; // return data from removed node!
	}
	public E get(int index) {
		ListNode<E> curr = head;
		for (int i=0; i<index;i++) {
			curr=curr.next;
		}
		return curr.data;
	}
	
	//should insert before the first occurrence of the value!
	//return true if the value is there and the operation was successful false if not successful
	public boolean insertBefore(E newValue, E value) {
		boolean wasInserted = false;
		ListNode<E> curr = head; //start at head!
		if (head.data==value) { // if the start of the list has the value then make the new value the start of the list
			head = new ListNode<E>(newValue, head);
			wasInserted = true;
			return wasInserted;
		}
		for (int i=0; i<size-1;i++) {// traverse to find the value limit is size-1 to not over step bounds
			if (curr.next.data==value) { // check if the next value is contains the value!
				ListNode<E> newNode = new ListNode<E>(newValue,curr.next);
				curr.next = newNode;
				wasInserted = true;
				size++; // increase list size!!!!
				return wasInserted;
			}
			curr=curr.next; //go to next node!
		}
		
		return wasInserted;
	}
	
	public void printList() {
		System.out.print("Current Elements in the data: ");
		ListNode<E> curr = head;//start at the head
		for (int i=0;i<size;i++) { //traverse through list
			System.out.print("[" + curr.data + "]");
			if (curr.next!=null) {
				System.out.print("->");
			}
			curr=curr.next;
		}
		System.out.println();
	}
	

	
	
	
	
	
	
	
}
